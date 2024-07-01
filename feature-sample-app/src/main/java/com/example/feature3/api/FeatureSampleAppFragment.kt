package com.example.feature3.api

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.core.common.findDependencies
import com.example.core.utils.SystemLogger
import com.example.feature3.R
import com.example.feature3.common.di.DaggerFeature3Component
import com.example.feature3.databinding.FragmentFeature3Binding
import javax.inject.Inject

class FeatureSampleAppFragment : Fragment(R.layout.fragment_feature_3) {

    @Inject internal lateinit var systemLogger: SystemLogger

    override fun onAttach(context: Context) {
        DaggerFeature3Component.factory()
            .create(findDependencies())
            .inject(this)
        super.onAttach(context)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Feature3Fragment", systemLogger.getStatus())
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View =
        FragmentFeature3Binding.inflate(layoutInflater, container, false).apply {
        }.root

    companion object {
        fun newInstance() = FeatureSampleAppFragment()
    }
}