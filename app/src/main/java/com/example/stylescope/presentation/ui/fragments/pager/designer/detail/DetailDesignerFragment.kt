package com.example.stylescope.presentation.ui.fragments.pager.designer.detail

import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentDetailDesignerBinding
import com.example.stylescope.presentation.ui.adapters.designer.design_reviews.DesignReviewsAdapter
import com.example.stylescope.presentation.ui.adapters.designer.design_works.DesignWorksAdapter
import com.example.stylescope.presentation.utils.loadImage
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailDesignerFragment : BaseFragment<FragmentDetailDesignerBinding, DetailDesignerViewModel>(
    R.layout.fragment_detail_designer
) {
    override val binding: FragmentDetailDesignerBinding by viewBinding(FragmentDetailDesignerBinding::bind)
    override val viewModel: DetailDesignerViewModel by viewModel()
    private val designWorksAdapter by lazy { DesignWorksAdapter() }
    private val designReviewsAdapter by lazy { DesignReviewsAdapter() }

    override fun launchObservers() {
        val args by navArgs<DetailDesignerFragmentArgs>()
        viewModel.getDetailCompanies(args.designerID)

        binding.rvReviews.adapter = designReviewsAdapter
        binding.companyWorksPager.adapter = designWorksAdapter
        viewModel.state.spectateUiState( success = {design ->
            binding.ilProfileDesign.loadImage(design.photo!!)
            binding.username.text = "${design.name}" + " " + "${design.surname}"
            binding.profesion.text = design.occupation
            binding.experinse.text = design.workEXP
            binding.aboutDesc.text = design.description
            binding.tvCountReviews.text = design.countReviews
            designWorksAdapter.submitList(design.gallery)
            designReviewsAdapter.submitList(design.reviews)

        },error = { errorMsg ->
            Toast.makeText(requireContext(), "Error $errorMsg", Toast.LENGTH_LONG).show()
            Log.e("ololo", errorMsg)
        })

    }
}