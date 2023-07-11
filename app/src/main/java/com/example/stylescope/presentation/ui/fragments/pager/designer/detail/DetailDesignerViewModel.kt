package com.example.stylescope.presentation.ui.fragments.pager.designer.detail

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.designer.GetDetailDesignerUseCase
import com.example.stylescope.domain.use_cases.favorite.SaveFavoriteDesignerUseCase
import com.example.stylescope.domain.use_cases.reviewdesigner.ReviewDesignerUseCase
import com.example.stylescope.presentation.model.answers.AnswerUI
import com.example.stylescope.presentation.model.answers.toLogInAnswerUI
import com.example.stylescope.presentation.model.designer.DesignerDetailUI
import com.example.stylescope.presentation.model.designer.DesignerFavoriteUI
import com.example.stylescope.presentation.model.designer.toUI
import com.example.stylescope.presentation.model.review.ReviewAnswerUI
import com.example.stylescope.presentation.model.review.ReviewSendUI
import com.example.stylescope.presentation.model.review.UserReviewsUI
import com.example.stylescope.presentation.model.review.toUI
import kotlinx.coroutines.flow.asStateFlow

class DetailDesignerViewModel(
    private val getDetailDesignerUseCase: GetDetailDesignerUseCase,
    private val saveFavoriteDesignerUseCase: SaveFavoriteDesignerUseCase
) : BaseViewModel() {
class DetailDesignerViewModel(
    private val getDetailDesignerUseCase: GetDetailDesignerUseCase,
    private val reviewDesignerUseCase: ReviewDesignerUseCase
) :
    BaseViewModel() {

    private val _state = mutableUIStateFlow<DesignerDetailUI>()
    val state = _state.asStateFlow()

    private val _saveDesignerState = mutableUIStateFlow<List<String>>()
    val saveDesignerState get() = _saveDesignerState.asStateFlow()
    fun getDetailCompanies(id: Int) {
        getDetailDesignerUseCase(id).gatherRequest(_state) { it.toUI() }
    }

    fun saveFavoriteDesigner(model: DesignerFavoriteUI, id: String) {
        saveFavoriteDesignerUseCase(model = model.toDomain(), id = id).gatherRequest(
            _saveDesignerState
        ) { it }
    }


    private val _reviewSend = mutableUIStateFlow<ReviewAnswerUI>()
    val reviewSend = _reviewSend.asStateFlow()

    fun sendReview(model: ReviewSendUI, id: String) {
        reviewDesignerUseCase.sendDesignerReview(model.toDomain(), id)
            .gatherRequest(_reviewSend) { it.toUI() }
    }

    private val _reviewDelete = mutableUIStateFlow<List<String>>()
    val reviewDelete = _reviewDelete

    fun deleteReview(designerId: String, id: String) {
        reviewDesignerUseCase.deleteDesignerReview(designerId, id)
            .gatherRequest(_reviewDelete) { it }
    }

    private val _reviewEdit = mutableUIStateFlow<ReviewAnswerUI>()
    val reviewEdit = _reviewEdit.asStateFlow()

    fun editReview(designerId: String, id: String, edit: ReviewSendUI) {
        reviewDesignerUseCase.editDesignerReview(designerId, id, edit.toDomain())
            .gatherRequest(_reviewEdit) { it.toUI() }
    }

    private val _reviewUser = mutableUIStateFlow<UserReviewsUI>()
    val reviewUser = _reviewUser.asStateFlow()

    fun getUserReview(designerId: String){
        reviewDesignerUseCase.getDesignerUserReview(designerId).gatherRequest(_reviewUser){it.toUI()}
    }
}