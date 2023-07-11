package com.example.stylescope.presentation.ui.fragments.pager.company.detail

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.company.GetDetailCompanyUseCase
import com.example.stylescope.domain.use_cases.favorite.SaveFavoriteCompanyUseCase
import com.example.stylescope.domain.use_cases.reviewcompany.ReviewCompanyUseCase
import com.example.stylescope.domain.use_cases.reviewcompany.ReviewCompanyUseCase
import com.example.stylescope.presentation.model.answers.AnswerUI
import com.example.stylescope.presentation.model.answers.toLogInAnswerUI
import com.example.stylescope.presentation.model.company.CompanyDetailUI
import com.example.stylescope.presentation.model.company.CompanyFavoriteUI
import com.example.stylescope.presentation.model.company.toUI
import com.example.stylescope.presentation.model.review.ReviewAnswerUI
import com.example.stylescope.presentation.model.review.ReviewSendUI
import com.example.stylescope.presentation.model.review.UserReviewsUI
import com.example.stylescope.presentation.model.review.toUI
import kotlinx.coroutines.flow.asStateFlow

class DetailCompanyVIewModel(
    private val getDetailCompanyUseCase: GetDetailCompanyUseCase,
    private val saveFavoriteCompanyUseCase: SaveFavoriteCompanyUseCase
    private val reviewDesignerUseCase: ReviewCompanyUseCase

) : BaseViewModel() {


    private val _state = mutableUIStateFlow<CompanyDetailUI>()
    val state = _state.asStateFlow()

    private val _saveCompanyState = mutableUIStateFlow<List<String>>()
    val saveCompanyState get() = _saveCompanyState.asStateFlow()

    fun getDetailCompanies(id: Int) {
        getDetailCompanyUseCase(id).gatherRequest(_state) { it.toUI() }
    }

    fun saveFavoriteCompany(model: CompanyFavoriteUI, id: String) =
        saveFavoriteCompanyUseCase(model = model.toDomain(), id = id).gatherRequest(
            _saveCompanyState
        ) { it }

    private val _reviewSend = mutableUIStateFlow<ReviewAnswerUI>()
    val reviewSend = _reviewSend.asStateFlow()

    fun sendReview(model: ReviewSendUI, id: String) {
        reviewDesignerUseCase.sendCompanyReview(model.toDomain(), id)
            .gatherRequest(_reviewSend) { it.toUI() }
    }

    private val _reviewDelete = mutableUIStateFlow<List<String>>()
    val reviewDelete = _reviewDelete

    fun deleteReview(companyId: String, id: String) {
        reviewDesignerUseCase.deleteCompanyReview(companyId, id)
            .gatherRequest(_reviewDelete) { it.map { it } }
    }

    private val _reviewEdit = mutableUIStateFlow<ReviewAnswerUI>()
    val reviewEdit = _reviewEdit.asStateFlow()

    fun editReview(companyId: String, id: String, edit: ReviewSendUI) {
        reviewDesignerUseCase.editCompanyReview(companyId, id, edit.toDomain())
            .gatherRequest(_reviewEdit) { it.toUI() }
    }

    private val _reviewUser = mutableUIStateFlow<UserReviewsUI>()
    val reviewUser = _reviewUser.asStateFlow()

    fun getUserReview(designerId: String){
        reviewDesignerUseCase.getCompanyUserReview(designerId).gatherRequest(_reviewUser){it.toUI()}
    }
}
