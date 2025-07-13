package com.example.feature2.internal.presentation.state

internal sealed class UiState<out T> {
    data class Data<T>(val data: T) : UiState<T>()
    data object NoArgs : UiState<Nothing>()
    data object Loading : UiState<Nothing>()
}