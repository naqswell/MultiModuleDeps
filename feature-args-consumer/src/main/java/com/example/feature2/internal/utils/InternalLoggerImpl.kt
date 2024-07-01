package com.example.feature2.internal.utils

import javax.inject.Inject

class InternalLoggerImpl @Inject constructor(): InternalLogger {
    override fun getStatus(): String = "Feature2InternalLogger"
}