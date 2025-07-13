package com.example.feature2.internal.presentation.mapper

import com.example.feature2.api.FeatureArgsConsumerFragment

internal data class DataDisplayable(
    val id: Int,
    val additional: String,
)

internal fun FeatureArgsConsumerFragment.Args.toDisplayableModel() = DataDisplayable(
    id = id,
    additional = additional
)
