package com.example.stylescope.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylescope.common.Either
import com.example.stylescope.common.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> mutableUIStateFlow() = MutableStateFlow<UIState<T>>(UIState.Idle())

    protected fun <T, S> Flow<Either<String, T>>.gatherRequest(
        state: MutableStateFlow<UIState<S>>,
        mappedData: (data: T) -> S,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UIState.Loading()
            this@gatherRequest.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value)
                    is Either.Right -> state.value =
                        UIState.Success(mappedData(it.value))
                }
            }
        }
    }
}