package com.example.feature_threads.internal.screenflows.host

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.core.common.findDependencies
import com.example.feature_threads.R
import com.example.feature_threads.databinding.FragmentHostBinding
import com.example.feature_threads.internal.navigation.ScreenNavigator
import com.example.feature_threads.internal.screenflows.host.di.DaggerHostFragmentComponent
import javax.inject.Inject

class HostFragment : Fragment(R.layout.fragment_host) {

    @Inject lateinit var screenNavigator: ScreenNavigator

    override fun onAttach(context: Context) {
        DaggerHostFragmentComponent.factory().create(findDependencies()).apply {
            inject(this@HostFragment)
        }
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentHostBinding.bind(view).apply {
            initLayout()
        }
    }

    private fun FragmentHostBinding.initLayout() {
        btnCustomHandler.apply {
            text = "Custom Handler"
            setOnClickListener { screenNavigator.onCustomHandlerScreen() }
        }
    }

    companion object {
        fun newInstance() = HostFragment().apply {
        }
    }
}