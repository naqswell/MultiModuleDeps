package com.example.feature_compound_view.internal.utils

import javax.inject.Inject

internal class InternalLoggerImpl @Inject constructor(): InternalLogger {
    override fun getStatus(): String = "FeatureCompoundVIewInternalLogger"
}