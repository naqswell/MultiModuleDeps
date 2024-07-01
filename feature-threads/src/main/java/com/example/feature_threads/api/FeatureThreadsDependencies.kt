package com.example.feature_threads.api

import com.example.core.common.Dependencies
import com.example.core.utils.SystemLogger

interface FeatureThreadsDependencies: Dependencies {
    val systemLogger: SystemLogger
}