package com.example.stylescope.presentation.ui.fragments.pager.designer.detail

import android.annotation.SuppressLint
import android.util.Log
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.common.UIState
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.FragmentDetailDesignerBinding
import com.example.stylescope.presentation.model.designer.DesignerFavoriteUI
import com.example.stylescope.presentation.model.review.ReviewSendUI
import com.example.stylescope.presentation.ui.adapters.designer.design_reviews.DesignReviewsAdapter
import com.example.stylescope.presentation.ui.adapters.designer.design_works.DesignWorksAdapter
import com.example.stylescope.presentation.ui.fragments.pager.company.detail.DetailCompanyFragmentArgs
import com.example.stylescope.presentation.ui.fragments.pager.log_out.NotRegisterDialogFragment
import com.example.stylescope.presentation.utils.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailDesignerFragment : BaseFragment<FragmentDetailDesignerBinding, DetailDesignerViewModel>(
    R.layout.fragment_detail_designer
) {
    override val binding: FragmentDetailDesignerBinding by viewBinding(FragmentDetailDesignerBinding::bind)
    override val viewModel: DetailDesignerViewModel by viewModel()
    private val designWorksAdapter by lazy { DesignWorksAdapter() }
    private val designReviewsAdapter by lazy { DesignReviewsAdapter() }
    private val pref: Pref by lazy { Pref(requireContext()) }
    private var isEdit = false
    private val args by navArgs<DetailDesignerFragmentArgs>()
    private var reviewId = 1
    private var reviewEmpty = false
    override fun initialize() {
        super.initialize()
        viewModel.getDetailCompanies(args.designerID)
        initAdapter()
        reviewEditDelete()
    }


    override fun launchObservers() {
        detailDesignerState()
        sendReviewState()
        deleteReviewState()
        editReviewState()
        getDesignerUserReview()




        binding.rvReviews.adapter = designReviewsAdapter
        binding.companyWorksPager.adapter = designWorksAdapter
        viewModel.state.spectateUiState(success = { design ->
            binding.ilProfileDesign.loadImage(design.photo!!)
            binding.username.text = "${design.name}" + " " + "${design.surname}"
            binding.profesion.text = design.occupation
            binding.experinse.text = design.workEXP
            binding.aboutDesc.text = design.description
            binding.tvCountReviews.text = design.countReviews
            designWorksAdapter.submitList(design.gallery)
            designReviewsAdapter.submitList(design.reviews)

        }, error = { errorMsg ->
            Toast.makeText(requireContext(), "Error $errorMsg", Toast.LENGTH_LONG).show()
            Log.e("ololo", errorMsg)
        })
    }

    override fun constructListeners() {
        super.constructListeners()
        with(binding) {
            btnLeaveFeedback.setOnClickListener {
                if (isEdit) {
                    reviewCheck {
                        viewModel.editReview(
                            "1",
                            reviewId.toString(),
                            it as ReviewSendUI
                        )
                    }
                } else {
                    reviewCheck { viewModel.sendReview(it as ReviewSendUI, "1") }
                }
            }
        }
    }


    private fun detailDesignerState() {
        with(binding) {
            val favoriteDesignerId = pref.getFavoriteDesignerId()
            if (favoriteDesignerId != null && favoriteDesignerId == args.designerID) {
                ilBtnFavorite.setImageResource(R.drawable.ic_favorite_ram_select)
            } else {
                ilBtnFavorite.setImageResource(R.drawable.ic_favorite_ram)
            }

            ilBtnFavorite.setOnClickListener {
                if (favoriteDesignerId != null && favoriteDesignerId == args.designerID) {
                    // Already selected, remove from favorites
                    ilBtnFavorite.setImageResource(R.drawable.ic_favorite_ram)
                    pref.saveFavoriteDesignerId(0)
                } else {
                    // Not selected, mark as favorite
                    ilBtnFavorite.setImageResource(R.drawable.ic_favorite_ram_select)
                    pref.saveFavoriteDesignerId(args.designerID)
                }
                viewModel.saveFavoriteDesigner(
                    DesignerFavoriteUI(
                        designerId = args.designerID
                    ), id = args.designerID.toString()
                )
            }

            if (pref.showToken() != null) {
                btnLeaveFeedback.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.urmat_blue)
            } else {
                btnLeaveFeedback.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.urmat_light_gray)
                btnLeaveFeedback.setOnClickListener {
                    NotRegisterDialogFragment().show(
                        requireActivity().supportFragmentManager,
                        ""
                    )
                }
            }
            viewModel.state.spectateUiState(success = { design ->
                viewModel.getUserReview("1")
                design.photo?.let { ilProfileDesign.loadImage(it) }
                username.text = "${design.name}" + " " + "${design.surname}"
                profesion.text = design.occupation
                experinse.text = design.workEXP
                aboutDesc.text = design.description
                tvCountReviews.text = design.countReviews
                designWorksAdapter.submitList(design.gallery)
                designReviewsAdapter.submitList(design.reviews)
            }, error = { errorMsg ->
                Toast.makeText(requireContext(), "Error $errorMsg", Toast.LENGTH_LONG).show()
            },
                gatherIfSucceed = {
                    loading.progressBar.isVisible = it is UIState.Loading
                })
        }
    }


    private fun sendReviewState() {
        with(binding) {
            viewModel.reviewSend.spectateUiState(
                success = {
                    viewModel.getUserReview("1")
                    it.userPhoto?.let { it1 -> imgUserReviews.loadImage(it1) }
                    etUserReviews.clearFocus()
                    rank.rating = 0.0F
                    etUserReviews.text?.clear()
                }, error = { errorMsg ->
                    Toast.makeText(requireContext(), "Error $errorMsg", Toast.LENGTH_SHORT)
                        .show()
                },
                gatherIfSucceed = {
                    loading.progressBar.isVisible = it is UIState.Loading
                })
        }
    }


    private fun deleteReviewState() {
        viewModel.reviewDelete.spectateUiState(
            success = {
                viewModel.getUserReview("1")
                Toast.makeText(requireContext(), "Successfully deleted", Toast.LENGTH_SHORT).show()
            },
            error = {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            },
            gatherIfSucceed = {
                binding.loading.progressBar.isVisible = it is UIState.Loading
            }
        )
    }

    private fun editReviewState() {
        with(binding) {
            viewModel.reviewEdit.spectateUiState(
                success = {
                    viewModel.getUserReview("1")
                    etUserReviews.clearFocus()
                    etUserReviews.text?.clear()
                    rank.rating = 0.0F
                    isEdit = false
                    Toast.makeText(requireContext(), "Successfully edited", Toast.LENGTH_SHORT)
                        .show()
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

    @SuppressLint("SetTextI18n")
    private fun getDesignerUserReview() {
        with(binding) {
            viewModel.reviewUser.spectateUiState(
                success = {
                    if (it.user_reviews?.isEmpty() == true) {
                        doneReview.isVisible = false
                        reviewEmpty = true
                    } else {
                        reviewEmpty = false
                        it.user_reviews?.get(0)?.let { id -> reviewId = id.id }
                        imgUserReviewsRating.rating = it.user_reviews?.get(0)?.rank?.toFloat()!!
                        tvUserReviews.text = it.user_reviews[0].text
                        tvReviewsHours.text = it.user_reviews[0].time_since_published
                        tvNameReviews.text =
                            "${it.user_reviews[0].first_name} ${it.user_reviews[0].last_name}"
                        doneReview.isVisible = true
                    }
                },
                error = {
                    Toast.makeText(
                        requireContext(),
                        "Error from getting reviews",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                gatherIfSucceed = {
                    loading.progressBar.isVisible = it is UIState.Loading
                }
            )
        }
    }


    private fun reviewEditDelete() {
        with(binding) {
            val popUpMenu = PopupMenu(requireContext(), binding.btnBurgerMenu)
            val inflater = popUpMenu.menuInflater
            inflater.inflate(R.menu.popup_review_menu, popUpMenu.menu)
            btnBurgerMenu.setOnClickListener {
                popUpMenu.show()
            }
            popUpMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.delete -> {
                        if (!reviewEmpty) {
                            viewModel.deleteReview("1", reviewId.toString())
                        }
                        true
                    }

                    R.id.reduct -> {
                        etUserReviews.setText(tvUserReviews.text.toString())
                        isEdit = true
                        true
                    }

                    else -> true
                }
            }
        }
    }

    private fun reviewCheck(request: (model: Any) -> Unit) {
        with(binding) {
            val rank = rank.rating.toInt()
            val text = etUserReviews.text.toString()
            val model = ReviewSendUI(rank = rank, text = text)
            if (rank > 0 && text.isNotEmpty()) {
                request(model)
            } else {
                Toast.makeText(requireContext(), "Оставьте рейтинг и отзыв", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun initAdapter() {
        binding.rvReviews.adapter = designReviewsAdapter
        binding.companyWorksPager.adapter = designWorksAdapter
    }
}