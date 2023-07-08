package com.example.stylescope.presentation.ui.fragments.pager.company

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentCompaniesBinding
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
    override fun launchObservers() {
        binding.rvCompanies.adapter = adapter
        viewModel.companyState.spectateUiState(success = { companies ->
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
        binding.etSearch.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
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
        val packageNamesSet = mutableSetOf<String>()
        packages.forEach { packageUI ->
            packageNamesSet.add(packageUI.title!!)
        }

        val packageNames = packageNamesSet.toList()
        val arrayAdapter = ArrayAdapter(requireActivity(), R.layout.dropdown_filterservice_item, packageNames)
        binding.etService.setAdapter(arrayAdapter)

        binding.etService.setOnClickListener {
            binding.etService.showDropDown()
        }

        binding.etService.setOnItemClickListener { _, _, position, _ ->
            val selectedPackageName = packageNames[position]
            filterByPackageTitle(selectedPackageName)
            selectedPackage = selectedPackageName
            applyFilters()
        }
    }

    private fun setupServiceDropdownMenu(service: List<ServicesUI>) {
        val serviceNameSet = mutableSetOf<String>()
        service.forEach { serviceUI ->
            serviceNameSet.add(serviceUI.title!!)
        }

        val serviceName = serviceNameSet.toList()
        val arrayAdapter = ArrayAdapter(requireActivity(),R.layout.dropdown_filterservice_item2,serviceName)
        binding.filledExposed.setAdapter(arrayAdapter)

        binding.filledExposed.setOnClickListener {
            binding.filledExposed.showDropDown()
        }

        binding.filledExposed.setOnItemClickListener { _, _, position, _ ->
            val selectedServiceName = serviceName[position]
            filterByServiceTitle(selectedServiceName)
            selectedService = selectedServiceName
            applyFilters()
        }
    }

    private fun filterByPackageTitle(title: String) {
        val filteredPackages = list.filter { companyUI ->
            companyUI.services!!.any { packageUI ->
                packageUI.title.equals(title, ignoreCase = true)
            }
        }
        adapter.submitList(filteredPackages)
    }

    private fun filterByServiceTitle(title:String) {
        val filterServices = list.filter { companyUI ->
            companyUI.packages!!.any{ serviceUI ->
                serviceUI.title.equals(title,true)
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
