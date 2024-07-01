package com.example.feature2.internal.presentation.mapper

import com.example.feature2.api.FeatureArgsConsumerFragment

data class DataDisplayable(
    val id: Int,
    val additional: String,
)

fun FeatureArgsConsumerFragment.Args.toDisplayableModel() = DataDisplayable(
    id = id,
    additional = additional
)
