package com.example.stylescope.presentation.ui.fragments.favorite.detail

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.common.UIState
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentFavoriteDetailBinding
import com.example.stylescope.presentation.ui.adapters.company.CompanyAdapter
import com.example.stylescope.presentation.ui.adapters.designer.DesignerAdapter
import com.example.stylescope.presentation.ui.fragments.favorite.FavoriteFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteDetailFragment :
    BaseFragment<FragmentFavoriteDetailBinding, FavoriteDetailViewModel>(R.layout.fragment_favorite_detail) {
    override val binding: FragmentFavoriteDetailBinding by viewBinding(FragmentFavoriteDetailBinding::bind)
    override val viewModel: FavoriteDetailViewModel by viewModel()
    private var isItCompany = false
    private val adapterCompany: CompanyAdapter by lazy { CompanyAdapter(this::clickCompany) }
    private val adapterDesigner: DesignerAdapter by lazy { DesignerAdapter(this::clickDesigner) }


    override fun initialize() {
        super.initialize()
        receiveData()
        initAdapter()
    }

    @SuppressLint("SetTextI18n")
    override fun launchObservers() {
        super.launchObservers()
        with(binding) {
            viewModel.getFavorites()
            viewModel.state.spectateUiState(
                success = {
                    if (isItCompany) {
                        tvCompanies.text = "Компании"
                        favoriteCount.text = "${it.companies?.size} избранных"
                        adapterCompany.submitList(it.companies)
                    } else {
                        tvCompanies.text = "Дизайнеры"
                        favoriteCount.text = "${it.designers?.size} избранных"
                        adapterDesigner.submitList(it.designers)
                    }
                },
                error = {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                },
                gatherIfSucceed = {
                    loading.progressBar.isVisible = it is UIState.Loading
                }
            )
        }
    }

    private fun initAdapter() {
        with(binding) {
            rvCompanies.isVisible = isItCompany
            rvDesigners.isVisible = !isItCompany
            rvCompanies.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvCompanies.adapter = adapterCompany
            rvDesigners.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvDesigners.adapter = adapterDesigner
        }
    }


    private fun receiveData() {
        arguments?.let {
            isItCompany = it.getBoolean(FavoriteFragment.KEY_FAVORITE)
        }
    }


    private fun clickCompany(id: Int) {

    }

    private fun clickDesigner(id: Int) {

    }

}