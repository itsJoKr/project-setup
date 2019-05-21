package com.example.jokr.propermock.common

data class ViewState<out State : Any>(
    val viewState: State? = null,
    var commonState: CommonState = CommonState()
)

data class CommonState(
    val loadingState: LoadingState = LoadingState.Idle,
    val errorState: ErrorState = ErrorState.NoError
)

sealed class LoadingState {

    object Idle : LoadingState()
    object Loading : LoadingState()
}

sealed class ErrorState {

    open val error: String = "Unknown error"

    object NoError : ErrorState()
    data class ErrorMessage(override val error: String) : ErrorState()
    data class UnknownError(override val error: String) : ErrorState()
    data class NoNetwork(override val error: String) : ErrorState()
}