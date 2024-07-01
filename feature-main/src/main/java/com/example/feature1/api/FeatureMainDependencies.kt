package com.example.feature1.api

import com.example.core.common.Dependencies

interface FeatureMainDependencies: Dependencies {
    val otherFeatureFragment: OtherFeaturesCommunicator
}

interface OtherFeaturesCommunicator {
    fun onOpenFeatureArgs(id: Int, additional: String)
    fun onOpenFeatureCompoundView()
    fun onOpenFeatureThreads()
}