package com.example.stylescope.presentation.ui.fragments.pager.designer

import android.util.Log
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentDesignerBinding
import com.example.stylescope.presentation.model.designer.DesignerUI
import com.example.stylescope.presentation.ui.adapters.designer.DesignerAdapter
import com.example.stylescope.presentation.ui.fragments.pager.PagerFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class DesignerFragment :
    BaseFragment<FragmentDesignerBinding, DesignerViewModel>(R.layout.fragment_designer) {
    override val binding: FragmentDesignerBinding by viewBinding(FragmentDesignerBinding::bind)
    override val viewModel: DesignerViewModel by viewModel()
    private val adapter : DesignerAdapter by lazy { DesignerAdapter(this::click) }
    private var list = mutableListOf<DesignerUI>()


    override fun launchObservers() {
        binding.rvDesigners.adapter = adapter
        viewModel.companyState.spectateUiState(success = {designers ->
            adapter.submitList(designers)
            list.addAll(designers)
        }, error = { errorMsg ->
            Log.e("ololo", errorMsg)
        })
    }

    override fun constructListeners() {
        binding.etSearch.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
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
        val searchData = list.filter { it.name.contains(name, ignoreCase = true) }
        if (searchData.isNotEmpty()) {
            adapter.submitList(searchData)
            binding.badRequest.root.isGone = true
            binding.rvDesigners.isVisible = true
        } else {
            binding.badRequest.root.isVisible = true
            binding.rvDesigners.isGone = true
        }
    }

    private fun click(id: Int) {
//        findNavController().navigate(PagerFragmentDirections.actionPagerFragmentToDetailDesignerFragment(id))
    }
}