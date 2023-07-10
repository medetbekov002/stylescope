package com.example.stylescope.presentation.ui.fragments.favorite

import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.common.UIState
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.FragmentFavoriteBinding
import com.example.stylescope.presentation.ui.adapters.company.CompanyAdapter
import com.example.stylescope.presentation.ui.adapters.designer.DesignerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteFragment :
    BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>(R.layout.fragment_favorite) {

    override val binding: FragmentFavoriteBinding by viewBinding(FragmentFavoriteBinding::bind)
    override val viewModel: FavoriteViewModel by viewModel()
    private val adapterCompany: CompanyAdapter by lazy { CompanyAdapter(this::clickCompany) }
    private val adapterDesigner: DesignerAdapter by lazy { DesignerAdapter(this::clickDesigner) }
    private val pref: Pref by lazy { Pref(requireContext()) }

    private fun saveCompany(id: Int) {

    }
    companion object{
        const val KEY_FAVORITE = "favorite"
    }

    override fun initialize() {
        super.initialize()
        initAdapters()
    }


    override fun constructListeners() {
        super.constructListeners()
        with(binding) {
            btnCompanies.setOnClickListener {
                findNavController().navigate(R.id.favoriteDetailFragment, bundleOf(KEY_FAVORITE to true))
            }
            btnDesigners.setOnClickListener {
                findNavController().navigate(R.id.favoriteDetailFragment, bundleOf(KEY_FAVORITE to false))
            }
        }
    }

    override fun launchObservers() {
        super.launchObservers()
        with(binding) {
            viewModel.getFavorites()
            viewModel.state.spectateUiState(
                success = {
                    adapterCompany.submitList(it.companies)
                    adapterDesigner.submitList(it.designers)
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