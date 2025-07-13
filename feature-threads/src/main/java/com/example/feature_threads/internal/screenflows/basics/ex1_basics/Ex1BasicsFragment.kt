package com.example.feature_threads.internal.screenflows.basics.ex1_basics

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.feature_threads.R
import com.example.feature_threads.databinding.FragmentEx1BasicsBinding
import kotlin.concurrent.thread

internal class Ex1BasicsFragment: Fragment(R.layout.fragment_ex1_basics) {

    companion object {
        fun newInstance() : Fragment = Ex1BasicsFragment().apply {}

        private const val ITERATIONS_COUNTER_DURATION_SEC = 10
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentEx1BasicsBinding.bind(view).apply {
            initUi()
        }
    }

    private fun FragmentEx1BasicsBinding.initUi() {
        btnCountIterations.setOnClickListener { countIterations() }
    }

    private fun countIterations() {
        thread(start = true) {
            Log.d("Exercise1", "start")
            val startTimestamp = System.currentTimeMillis()
            val endTimestamp = startTimestamp + ITERATIONS_COUNTER_DURATION_SEC * 1000

            var iterationsCount = 0
            while (System.currentTimeMillis() <= endTimestamp) {
                iterationsCount++
            }
            Log.d(
                "Exercise1",
                "iterations in $ITERATIONS_COUNTER_DURATION_SEC  seconds: + $iterationsCount"
            )
        }
    }
}