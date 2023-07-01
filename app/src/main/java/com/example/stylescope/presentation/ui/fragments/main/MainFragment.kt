package com.example.stylescope.presentation.ui.fragments.main

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentMainBinding
import com.example.stylescope.presentation.model.company.CompanyUI
import com.example.stylescope.presentation.ui.adapters.company.CompanyAdapter
import com.example.stylescope.presentation.ui.adapters.designer.DesignerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {
    override val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModel()
    private val adapter: CompanyAdapter by lazy { CompanyAdapter(this::click) }
    private val list = mutableListOf<CompanyUI>()
    private val adapterDesigner : DesignerAdapter by lazy { DesignerAdapter(this::clicks) }

    private fun clicks(i: Int) {

    }


    override fun launchObservers() {
        binding.viewPagerCompany.adapter = adapter
        binding.viewPagerDesign.adapter = adapterDesigner
        viewModel.companyState.spectateUiState (success = { companies ->
            adapter.submitList(companies)
            list.addAll(companies)
        })


        viewModel.designerState.spectateUiState (success = { designers ->
        })
    }

    override fun constructListeners() {
        binding.tvWatchAllCompanies.setOnClickListener {
            findNavController().navigate(R.id.companiesFragment)
        }

        binding.tvWatchAllDesigners.setOnClickListener {
            findNavController().navigate(R.id.designerFragment)
        }
    }

    private fun click(id: Int) {}

}