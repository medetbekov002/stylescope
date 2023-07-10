package com.example.stylescope.presentation.ui.fragments.myreviews

import com.example.stylescope.core.BaseViewModel
import com.example.stylescope.domain.use_cases.myreviews.MyReviewsUseCase
import com.example.stylescope.presentation.model.myreviews.MyReviewsUI
import com.example.stylescope.presentation.model.myreviews.toMyReviewsUI
import kotlinx.coroutines.flow.asStateFlow

class MyReviewsViewModel(private val myReviewsUseCase: MyReviewsUseCase):BaseViewModel(){

    private val _state = mutableUIStateFlow<MyReviewsUI>()
    val state = _state.asStateFlow()

    fun getFavorites(){
        myReviewsUseCase().gatherRequest(_state){it.toMyReviewsUI()}
    }

}