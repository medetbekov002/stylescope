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
import com.example.stylescope.presentation.model.company.CompanyUI
import com.example.stylescope.presentation.ui.adapters.company.CompanyAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompaniesFragment :
        BaseFragment<FragmentCompaniesBinding, CompaniesViewModel>(R.layout.fragment_companies) {
    override val binding: FragmentCompaniesBinding by viewBinding(FragmentCompaniesBinding::bind)
    override val viewModel: CompaniesViewModel by viewModel()
    private val adapter: CompanyAdapter by lazy { CompanyAdapter(this::click) }
    private var list = mutableListOf<CompanyUI>()

    override fun launchObservers() {
        binding.rvCompanies.adapter = adapter
        viewModel.companyState.spectateUiState(success = { companies ->
            adapter.submitList(companies)
            list.addAll(companies)
        })
    }

    override fun constructListeners() {
        setupDropdownMenu()
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
         val services = listOf("Услуга 1", "Услуга 2", "Услуга 3") // Замените на ваш список услуг
        val items = list.flatMap { company -> company.packages.map { it.title } }.distinct()
    }



        private fun searchInDataList(name: String) {
            val searchData = list.filter { it.title.contains(name, ignoreCase = true) }
            if (searchData.isNotEmpty()) {
                adapter.submitList(searchData)
                binding.badRequest.root.isGone = true
                binding.rvCompanies.isVisible = true
            } else {
                binding.badRequest.root.isVisible = true
                binding.rvCompanies.isGone = true
            }
        }

    private fun setupDropdownMenu() {
        val gender = arrayOf("Женский", "Мужской", "Другое")
        val arrayAdapter = ArrayAdapter(requireActivity(), R.layout.dropdown_filterservice_item, gender)
        binding.etService.setAdapter(arrayAdapter)
        Log.w("ololo", "setupDropdownMenu: ", )

        // Добавляем обработчик нажатия на AutoCompleteTextView
        binding.etService.setOnClickListener {
            binding.etService.showDropDown()
        }
    }



    private fun click(id: Int) {
        val bundle = Bundle()
        bundle.putInt("companyID", id)
        findNavController().navigate(R.id.detailCompanyFragment, bundle)
        Log.w("ololo", "click: $id")
    }
}