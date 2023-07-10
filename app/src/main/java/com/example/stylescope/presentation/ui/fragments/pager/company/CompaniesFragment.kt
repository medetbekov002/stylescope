package com.example.stylescope.presentation.ui.fragments.pager.company

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentCompaniesBinding
import com.example.stylescope.presentation.model.company.CompanyFavoriteUI
import com.example.stylescope.presentation.model.company.CompanyPackageUI
import com.example.stylescope.presentation.model.company.CompanyUI
import com.example.stylescope.presentation.model.company.ServicesUI
import com.example.stylescope.presentation.ui.adapters.company.CompanyAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompaniesFragment :
    BaseFragment<FragmentCompaniesBinding, CompaniesViewModel>(R.layout.fragment_companies) {
    override val binding: FragmentCompaniesBinding by viewBinding(FragmentCompaniesBinding::bind)
    override val viewModel: CompaniesViewModel by viewModel()
    private val adapter: CompanyAdapter by lazy { CompanyAdapter(this::click) }
    private var list = mutableListOf<CompanyUI>()
    private var selectedPackage: String? = null
    private var selectedService: String? = null

    private fun saveCompany(id: Int) {
        viewModel.saveFavoriteCompany(model = CompanyFavoriteUI(companyId = id), id.toString())
    }
    override fun launchObservers() {
        binding.rvCompanies.adapter = adapter

        viewModel.saveCompanyState.spectateUiState(success = {
            Toast.makeText(requireContext(), "Успешно сохранено", Toast.LENGTH_SHORT).show()
            Log.e("favorite", "Успешно сохранено")
        }, error = {
            Log.e("favorite", it)
        })

        viewModel.companyState.spectateUiState(
            success = { companies ->
                adapter.submitList(companies)
                list.addAll(companies)

                val packages = companies.flatMap { companyUI ->
                    companyUI.packages!!.mapNotNull { it as? CompanyPackageUI }
                }

                val services = companies.flatMap { companyUI ->
                    companyUI.services!!.mapNotNull { it as? ServicesUI }
                }

                setupDropdownMenu(packages)
                setupServiceDropdownMenu(services)
            })
    }

    override fun constructListeners() {
        var filterState = false
        binding.imgFilter.setOnClickListener {
            if (!filterState) {
                binding.imgFilter.setImageResource(R.drawable.ic_filter_click)
                binding.layoutContainer.isVisible = true
                filterState = true
            } else {
                binding.imgFilter.setImageResource(R.drawable.ic_filter)
                binding.layoutContainer.isGone = true
                filterState = false
            }
        }
        binding.etSearch.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { searchInDataList(it) }
                binding.badRequest.itemTvRequestWord.text = newText
                applyFilters()
                return true
            }
        })

        binding.etSearch.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { searchInDataList(it) }
                binding.badRequest.itemTvRequestWord.text = newText
                return true
            }
        })
    }

    private fun searchInDataList(name: String) {
        val searchData = list.filter { it.title?.contains(name, ignoreCase = true) == true }
        if (searchData.isNotEmpty()) {
            adapter.submitList(searchData)
            binding.badRequest.root.isGone = true
            binding.rvCompanies.isVisible = true
        } else {
            binding.badRequest.root.isVisible = true
            binding.rvCompanies.isGone = true
        }
    }

    private fun click(id: Int) {
        val bundle = Bundle()
        bundle.putInt("companyID", id)
        findNavController().navigate(R.id.detailCompanyFragment, bundle)
        Log.w("ololo", "click: $id")
    }

    private fun setupDropdownMenu(packages: List<CompanyPackageUI>) {
        var filterState = false
        val packageNamesSet = mutableSetOf<String>()
        packages.forEach { packageUI ->
            packageNamesSet.add(packageUI.title!!)
        }

        val packageNames = packageNamesSet.toList()
        val limitedPackageNames = packageNames.subList(
            0,
            minOf(3, packageNames.size)
        ) // Получаем ограниченный подсписок с максимум тремя элементами
        val arrayAdapter = ArrayAdapter(
            requireActivity(),
            R.layout.dropdown_filterservice_item,
            limitedPackageNames
        )
        binding.etClasses.setAdapter(arrayAdapter)

        binding.etClasses.setOnClickListener {
            binding.etClasses.showDropDown()
        }

        binding.etClasses.setOnItemClickListener { _, _, position, _ ->
            val selectedPackageName = limitedPackageNames[position]
            filterByPackageTitle(selectedPackageName)
            selectedPackage = selectedPackageName
            applyFilters()
        }
        binding.etClasses.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Не используется, оставляем пустым
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Не используется, оставляем пустым
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length ?: 0 > 0) {
                    binding.inputClass.hint = null // Установка пустого значения подсказки
                    binding.inputClass.setEndIconDrawable(R.drawable.ic_done)
                } else {
                    binding.inputClass.hint = "Выбрать класс"
                }
            }
        })
        binding.etClasses.setOnClickListener {
            if (!filterState) {
                binding.etClasses.showDropDown()
                binding.inputClass.setEndIconDrawable(R.drawable.ic_done_up)
                filterState = true
            } else {
                binding.inputClass.setEndIconDrawable(R.drawable.ic_done)
                filterState = false
            }
        }
    }

    private fun setupServiceDropdownMenu(service: List<ServicesUI>) {
        val serviceNameSet = mutableSetOf<String>()
        service.forEach { serviceUI ->
            serviceNameSet.add(serviceUI.title!!)
        }

        val serviceName = serviceNameSet.toList()
        val arrayAdapter =
            ArrayAdapter(requireActivity(), R.layout.dropdown_filterservice_item2, serviceName)
        binding.etService.setAdapter(arrayAdapter)
        binding.etService.setOnClickListener {
            binding.etService.showDropDown()
        }
        binding.etService.setOnItemClickListener { _, _, position, _ ->
            val selectedServiceName = serviceName[position]
            filterByServiceTitle(selectedServiceName)
            selectedService = selectedServiceName
            applyFilters()
        }
        binding.etService.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Не используется, оставляем пустым
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Не используется, оставляем пустым
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length ?: 0 > 0) {
                    binding.inputService.hint = null // Установка пустого значения подсказки
                } else {
                    binding.inputService.hint = "Добавить услугу" // Восстановление подсказки
                }
            }
        })
    }

    private fun filterByPackageTitle(title: String) {
        val filteredPackages = list.filter { companyUI ->
            companyUI.services!!.any { packageUI ->
                packageUI.title.equals(title, ignoreCase = true)
            }
        }
        adapter.submitList(filteredPackages)
    }

    private fun filterByServiceTitle(title: String) {
        val filterServices = list.filter { companyUI ->
            companyUI.packages!!.any { serviceUI ->
                serviceUI.title.equals(title, true)
            }
        }
        adapter.submitList(filterServices)
    }

    private fun applyFilters() {
        val filteredList = list.filter { companyUI ->
            val packageMatches = selectedPackage?.let { packageName ->
                companyUI.packages?.any { packageUI ->
                    packageUI.title.equals(packageName, ignoreCase = true)
                }
            } ?: true
            val serviceMatches = selectedService?.let { serviceName ->
                companyUI.services?.any { serviceUI ->
                    serviceUI.title.equals(serviceName, ignoreCase = true)
                }
            } ?: true
            packageMatches && serviceMatches
        }
        adapter.submitList(filteredList)
    }
}
