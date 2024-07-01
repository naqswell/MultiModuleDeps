package com.example.feature1.internal.common.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.feature1.api.OtherFeaturesCommunicator
import javax.inject.Inject

class FeatureMainViewModel @Inject constructor(
) : ViewModel() {

    private var featureArgsCommunicator: OtherFeaturesCommunicator? = null

    fun initCommunicator(communicator: OtherFeaturesCommunicator) {
        featureArgsCommunicator = communicator
    }

    private fun getIdFromString(string: String): Int? = string.toIntOrNull()

    fun onFeatureArgs(idAsText: String, additional: String) {
        getIdFromString(idAsText)?.let { id ->
            featureArgsCommunicator?.onOpenFeatureArgs(id = id, additional)
        }
    }

    fun onFeatureCompoundView() = featureArgsCommunicator?.onOpenFeatureCompoundView()
        ?: Log.e("FeatureMainViewModel", "communicator not attached")

    fun onFeatureThreads() = featureArgsCommunicator?.onOpenFeatureThreads()
        ?: Log.e("FeatureMainViewModel", "communicator not attached")
}