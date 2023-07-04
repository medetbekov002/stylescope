package com.example.stylescope.presentation.ui.fragments.pager

import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentWorksBinding
import com.example.stylescope.presentation.ui.fragments.pager.company.detail.DetailCompanyVIewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.presentation.ui.adapters.designer.design_works.DesignWorksAdapter


class WorksFragment : BaseFragment<FragmentWorksBinding,DetailCompanyVIewModel>(R.layout.fragment_works) {
    override val binding: FragmentWorksBinding by viewBinding(FragmentWorksBinding::bind)
    override val viewModel: DetailCompanyVIewModel by viewModel()
    private val companyWorksAdapter by lazy { DesignWorksAdapter() }

    override fun launchObservers() {
        val args by navArgs<WorksFragmentArgs>()
        viewModel.getDetailCompanies(args.companyID)
        binding.companyWorksPager.adapter = companyWorksAdapter
        viewModel.state.spectateUiState(success = { company ->
            companyWorksAdapter.submitList(company.gallery)
        }, error = { errorMsg ->
            Toast.makeText(requireContext(), "Error $errorMsg", Toast.LENGTH_LONG).show()
            Log.e("ololo", errorMsg)
        }
        )
    }
}