package com.example.stylescope.presentation.ui.fragments.pager.company.detail

import android.annotation.SuppressLint
import android.util.Log
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.common.UIState
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.FragmentDetailCompanyBinding
import com.example.stylescope.presentation.model.review.ReviewSendUI
import com.example.stylescope.presentation.model.company.CompanyFavoriteUI
import com.example.stylescope.presentation.ui.adapters.company.company_package.CompanyPackageAdapter
import com.example.stylescope.presentation.ui.adapters.company.company_reviews.CompanyReviewsAdapter
import com.example.stylescope.presentation.ui.adapters.company.company_team.CompanyTeamAdapter
import com.example.stylescope.presentation.ui.adapters.company.company_works.CompanyWorksAdapter
import com.example.stylescope.presentation.utils.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailCompanyFragment :
    BaseFragment<FragmentDetailCompanyBinding, DetailCompanyVIewModel>(R.layout.fragment_detail_company) {
    override val binding: FragmentDetailCompanyBinding by viewBinding(FragmentDetailCompanyBinding::bind)
    override val viewModel: DetailCompanyVIewModel by viewModel()
    private val packageAdapter by lazy {
        CompanyPackageAdapter()
    }
    private val teamAdapter by lazy { CompanyTeamAdapter() }
    private val companyWorksAdapter by lazy { CompanyWorksAdapter() }
    private val companyReviewsAdapter by lazy { CompanyReviewsAdapter() }
    private val pref: Pref by lazy { Pref(requireContext()) }
    private var isEdit = false
    private val args by navArgs<DetailCompanyFragmentArgs>()
    private var reviewId = 1
    private var reviewEmpty = false
    override fun initialize() {
        super.initialize()
        viewModel.getDetailCompanies(1)
        initAdapter()
        reviewEditDelete()
    }

    override fun launchObservers() {
        detailCompanyState()
        sendReviewState()
        deleteReviewState()
        editReviewState()
        getDesignerUserReview()

        binding.imgDetailSave.setOnClickListener {
            viewModel.saveFavoriteCompany(
                model = CompanyFavoriteUI(companyId = args.companyID),
                args.companyID.toString()
            )
        }

        viewModel.saveCompanyState.spectateUiState(success = {
            Toast.makeText(requireContext(), "Успешно сохранено", Toast.LENGTH_SHORT).show()
        }, error = {
            Log.e("ololo", it)
        })

        binding.rvPrices.adapter = packageAdapter
        binding.rvTeam.adapter = teamAdapter
        binding.companyWorksPager.adapter = companyWorksAdapter
        binding.rvReviews.adapter = companyReviewsAdapter


        viewModel.state.spectateUiState(success = { company ->
            company.image?.let { binding.imgDetailCompany.loadImage(it) }
            binding.tvDetailCompanyDes.text = company.about
            Log.w("ololo", "launchObservers: ${company.about}")
            binding.tvWhatsappContact.text = company.phoneNumber1
            val instagram = company.socialMedia1?.replace("https://www.instagram.com/", "")
            val insta = instagram?.replace("/", "")
            binding.tvInstagramContact.text = insta
            binding.tvGmailContact.text = company.email1
            binding.tvCompanyAddress.text = company.address
            packageAdapter.submitList(company.packages)
            teamAdapter.submitList(company.designers)
            companyWorksAdapter.submitList(company.gallery)
            companyReviewsAdapter.submitList(company.reviews)
            binding.tvSeeAllWorks.setOnClickListener {
                findNavController().navigate(
                    DetailCompanyFragmentDirections.actionDetailCompanyFragmentToWorksFragment(
                        args.companyID
                    )
                )
            }
        }, error = { errorMsg ->
            Toast.makeText(requireContext(), "Error $errorMsg", Toast.LENGTH_LONG).show()
            binding.tvDetailCompanyDes.text = errorMsg
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
            tvSeeAllWorks.setOnClickListener {
                findNavController().navigate(
                    DetailCompanyFragmentDirections.actionDetailCompanyFragmentToWorksFragment(
                        args.companyID
                    )
                )
            }
        }
    }


    private fun detailCompanyState() {
        with(binding) {
            viewModel.state.spectateUiState(
                success = { company ->
                    viewModel.getUserReview("1")
                    company.image?.let { imgDetailCompany.loadImage(it) }
                    tvDetailCompanyDes.text = company.about
                    tvWhatsappContact.text = company.phoneNumber1
                    val instagram =
                        company.socialMedia1?.replace("https://www.instagram.com/", "")
                    val insta = instagram?.replace("/", "")
                    tvInstagramContact.text = insta
                    tvGmailContact.text = company.email1
                    tvCompanyAddress.text = company.address
                    packageAdapter.submitList(company.packages)
                    teamAdapter.submitList(company.designers)
                    companyWorksAdapter.submitList(company.gallery)
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
                    etUserReviews.text?.clear()
                    rank.rating = 0.0F
                }, error = { errorMsg ->
                    Log.e("ololo", "DCF.sRS.rS.error: $errorMsg")
                    Toast.makeText(requireContext(), "Error $errorMsg", Toast.LENGTH_SHORT).show()
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
                    binding.rank.rating = 0.0F
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
        with(binding) {
            rvPrices.adapter = packageAdapter
            rvTeam.adapter = teamAdapter
            companyWorksPager.adapter = companyWorksAdapter
            rvReviews.adapter = companyReviewsAdapter
        }
    }

}

