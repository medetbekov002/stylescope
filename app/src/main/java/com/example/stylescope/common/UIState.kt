package com.example.stylescope.common

sealed class UIState<T> {
    class Idle<T> : UIState<T>()
    class Loading<T> : UIState<T>()
    class Error<T>(val error: String) : UIState<T>()
    class Success<T>(val data: T) : UIState<T>()
}
