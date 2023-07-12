package com.example.stylescope.presentation.ui.fragments.main

import android.util.Log
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.FragmentMainBinding
import com.example.stylescope.presentation.model.company.CompanyUI
import com.example.stylescope.presentation.model.designer.DesignerUI
import com.example.stylescope.presentation.ui.adapters.company.CompanyAdapter
import com.example.stylescope.presentation.ui.adapters.designer.DesignerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {
    override val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModel()
    private val comAdapter: CompanyAdapter by lazy { CompanyAdapter(this::click) }
    private val comList = mutableListOf<CompanyUI>()
    private val desList = mutableListOf<DesignerUI>()
    private val desAdapter : DesignerAdapter by lazy { DesignerAdapter(this::clicks) }
    private val prefs: Pref by lazy { Pref(requireContext()) }
    private fun clicks(id: Int) {
    }

    override fun launchObservers() {
        if (!prefs.showOnBoardingShow()) {
            findNavController().navigate(R.id.onBoardingFragment)
            prefs.saveOnBoarding(true)
        }
        binding.viewPagerCompany.adapter = comAdapter
        binding.viewPagerDesign.adapter = desAdapter
        viewModel.companyState.spectateUiState (success = { companies ->
            comAdapter.submitList(companies)
            comList.addAll(companies)
        })

        viewModel.designerState.spectateUiState (success = { designers ->
            desAdapter.submitList(designers)
            desList.addAll(designers)
        })
    }

    override fun constructListeners() {
        binding.tvWatchAllCompanies.setOnClickListener {
            findNavController().navigate(R.id.pagerFragment)
        }

        binding.tvWatchAllDesigners.setOnClickListener {
            findNavController().navigate(R.id.pagerFragment)
        }

        binding.imgLogo.setOnClickListener {
            findNavController().navigate(R.id.aboutUsFragment)
        }
    }

    private fun click(id: Int) {}

}