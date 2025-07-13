package com.example.feature2.internal.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.feature2.api.FeatureArgsConsumerFragment
import com.example.feature2.internal.presentation.mapper.DataDisplayable
import com.example.feature2.internal.presentation.mapper.toDisplayableModel
import com.example.feature2.internal.presentation.state.UiState
import com.example.feature2.internal.utils.InternalLogger
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class FeatureArgsConsumerViewModel @AssistedInject constructor(
    @Assisted private val args: FeatureArgsConsumerFragment.Args?,
    internalLogger: InternalLogger
) : ViewModel() {

    init {
        Log.d("FeatureArgsConsumerViewModel", internalLogger.getStatus())
    }

    private val _uiStateFlow = MutableStateFlow<UiState<DataDisplayable>>(UiState.Loading)
    val uiStateFlow get() = _uiStateFlow.asStateFlow()

    init {
        _uiStateFlow.value =
            args?.let { UiState.Data(it.toDisplayableModel()) } ?: UiState.NoArgs
    }

    @AssistedFactory
    interface Factory {
        fun create(args: FeatureArgsConsumerFragment.Args?): FeatureArgsConsumerViewModel
    }

}