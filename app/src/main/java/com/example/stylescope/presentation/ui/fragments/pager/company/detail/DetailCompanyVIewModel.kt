package com.example.stylescope.presentation.ui.fragments.pager.company.detail

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.company.GetDetailCompanyUseCase
import com.example.stylescope.domain.use_cases.review.SendReviewUseCase
import com.example.stylescope.presentation.model.company.CompanyDetailUI
import com.example.stylescope.presentation.model.company.toUI
import com.example.stylescope.presentation.model.review.ReviewAnswerUI
import com.example.stylescope.presentation.model.review.ReviewSendUI
import com.example.stylescope.presentation.model.review.toUI
import kotlinx.coroutines.flow.asStateFlow

class DetailCompanyVIewModel(
    private val getDetailCompanyUseCase: GetDetailCompanyUseCase,
    private val sendReviewUseCase: SendReviewUseCase
) : BaseViewModel() {


    private val _state = mutableUIStateFlow<CompanyDetailUI>()
    val state = _state.asStateFlow()

    fun getDetailCompanies(id: Int) {
        getDetailCompanyUseCase(id).gatherRequest(_state) { it.toUI() }
    }

    private val _review = mutableUIStateFlow<ReviewAnswerUI>()
    val review = _review.asStateFlow()

    fun sendReview(model: ReviewSendUI, id: String) {
        sendReviewUseCase(model.toDomain(), id).gatherRequest(_review) { it.toUI() }
    }
}