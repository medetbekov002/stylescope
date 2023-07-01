package com.example.stylescope.presentation.ui.fragments.pager.company.detail

import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentDetailCompanyBinding
import com.example.stylescope.presentation.ui.adapters.company.company_package.CompanyPackageAdapter
import com.example.stylescope.presentation.ui.adapters.company.company_team.CompanyTeamAdapter
import com.example.stylescope.presentation.ui.adapters.company.company_works.CompanyWorksAdapter
import com.example.stylescope.presentation.utils.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailCompanyFragment :
    BaseFragment<FragmentDetailCompanyBinding, DetailCompanyVIewModel>(R.layout.fragment_detail_company) {
    override val binding: FragmentDetailCompanyBinding by viewBinding(FragmentDetailCompanyBinding::bind)
    override val viewModel: DetailCompanyVIewModel by viewModel()
    private val args by navArgs<DetailCompanyFragmentArgs>()
    private val packageAdapter by lazy { CompanyPackageAdapter() }
    private val teamAdapter by lazy { CompanyTeamAdapter() }
    private val companyWorksAdapter by lazy { CompanyWorksAdapter() }


    override fun launchObservers() {
        with(binding) {
            viewModel.getDetailCompanies(args.companyID)

            rvPrices.adapter = packageAdapter
            rvTeam.adapter = teamAdapter
            companyWorksPager.adapter = companyWorksAdapter

            viewModel.state.spectateUiState(success = { company ->
                imgDetailCompany.loadImage(company.image)
                tvDetailCompanyDes.text = company.about
                tvWhatsappContact.text = company.phoneNumber1
                val instagram = company.socialMedia1.replace("https://www.instagram.com/", "")
                val insta = instagram.replace("/", "")
                tvInstagramContact.text = insta
                tvGmailContact.text = company.email1
                tvCompanyAddress.text = company.address
                packageAdapter.submitList(company.services)
                teamAdapter.submitList(company.designers)
                companyWorksAdapter.submitList(company.gallery)
            }, error = { errorMsg ->
                Toast.makeText(requireContext(), "Error $errorMsg", Toast.LENGTH_LONG).show()
                tvDetailCompanyDes.text = errorMsg
                Log.e("ololo", errorMsg)
            })
        }
    }
}