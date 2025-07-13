package com.example.feature_threads.internal.screenflows.host.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.core.common.findDependencies
import com.example.core.presentation.viewModelDelegate
import com.example.feature_threads.R
import com.example.feature_threads.databinding.FragmentHostBinding
import com.example.feature_threads.internal.screenflows.host.di.DaggerHostFragmentComponent
import com.example.feature_threads.internal.screenflows.host.di.HostFragmentComponent

internal class HostFragment : Fragment(R.layout.fragment_host) {

    companion object {
        fun newInstance(): Fragment = HostFragment().apply {}
    }

    private lateinit var injector: HostFragmentComponent
    private val viewModel: HostViewModel by viewModelDelegate { injector.viewModel }

    override fun onAttach(context: Context) {
        injector = DaggerHostFragmentComponent
            .factory()
            .create(
                dependencies = findDependencies()
            ).also {
                it.inject(this@HostFragment)
            }
        viewModel.configure(screenNavigator = injector.screenNavigator)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("HostFragment", "onViewCreated")
        FragmentHostBinding.bind(view).apply {
            initLayout()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HostFragment", "onDestroy")
    }

    private fun FragmentHostBinding.initLayout() {
        btnCustomHandler.apply {
            text = "Custom Handler"
            setOnClickListener { viewModel.onCustomHandlerScreen() }
        }

        btnExercise1.apply {
            text = "Exercise1"
            setOnClickListener { viewModel.onExercise1Screen() }
        }

        btnExercise2.apply {
            text = "Exercise2"
            setOnClickListener { viewModel.onExercise2Screen() }
        }

        btnExercise3.apply {
            text = "Exercise3"
            setOnClickListener { viewModel.onExercise3Screen() }
        }

        btnExercise4.apply {
            text = "Exercise4 Fibonacci"
            setOnClickListener { viewModel.onExercise4Screen() }
        }
    }
}