package com.example.stylescope.presentation.ui.fragments.myreviews

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.common.UIState
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.FragmentMyReviewsBinding
import com.example.stylescope.presentation.ui.fragments.myreviews.adapter.MyReviewCompanyAdapter
import com.example.stylescope.presentation.ui.fragments.myreviews.adapter.MyReviewDesignerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyReviewsFragment : BaseFragment<FragmentMyReviewsBinding,MyReviewsViewModel>(R.layout.fragment_my_reviews){
    override val binding: FragmentMyReviewsBinding by viewBinding(FragmentMyReviewsBinding::bind)
    override val viewModel: MyReviewsViewModel by viewModel()
    private val adapterCompany: MyReviewCompanyAdapter by lazy {MyReviewCompanyAdapter(this::clickCompany) }
    private val adapterDesigner: MyReviewDesignerAdapter by lazy { MyReviewDesignerAdapter(this::clickDesigner) }
    private val pref:Pref by lazy { Pref(requireContext()) }

    override fun initialize() {
        super.initialize()
        initAdapters()
    }

    override fun launchObservers() {
        super.launchObservers()
        with(binding) {
            viewModel.getFavorites()
            viewModel.state.spectateUiState(
                success = {
                    Log.e("ololo","MRF.lO.success.token:${pref.showToken()}")
                    Log.e("ololo","MRF.lO.success:$it")
                    adapterCompany.submitList(it.company_reviews)
                    adapterDesigner.submitList(it.designer_reviews)
                },
                error = {
                    Log.e("ololo","MRF.lO.error.token:${pref.showToken()}")
                    Log.e("ololo","MRF.lO.error:$it")
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                },
                gatherIfSucceed = {
                    loading.progressBar.isVisible = it is UIState.Loading
                }
            )
        }
    }



    private fun initAdapters() {
        with(binding) {
            rvCompanies.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvCompanies.adapter = adapterCompany
            rvDesigners.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvDesigners.adapter = adapterDesigner
        }
    }

    private fun clickCompany(id: Int) {

    }

    private fun clickDesigner(id: Int) {

    }

}