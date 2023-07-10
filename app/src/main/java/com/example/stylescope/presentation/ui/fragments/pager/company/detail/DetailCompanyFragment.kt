package com.example.stylescope.presentation.ui.fragments.pager.company.detail

import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentDetailCompanyBinding
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


    override fun launchObservers() {
        val args by navArgs<DetailCompanyFragmentArgs>()
        viewModel.getDetailCompanies(args.companyID)

        binding.imgDetailSave.setOnClickListener {
            viewModel.saveFavoriteCompany(
                model = CompanyFavoriteUI(companyId = args.companyID),
                args.companyID.toString()
            )
        }

        viewModel.saveCompanyState.spectateUiState(success =  {
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
}