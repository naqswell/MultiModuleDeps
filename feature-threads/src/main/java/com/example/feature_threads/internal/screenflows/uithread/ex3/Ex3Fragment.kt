package com.example.feature_threads.internal.screenflows.uithread.ex3

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.example.feature_threads.R
import com.example.feature_threads.databinding.FragmentEx3Binding
import kotlin.concurrent.thread

internal class Ex3Fragment : Fragment(R.layout.fragment_ex3) {

    companion object {
        fun newInstance(): Fragment = Ex3Fragment().apply {}

        private val SECONDS_TO_COUNT = 3
    }

    private val mUiHandler = Handler(Looper.getMainLooper())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentEx3Binding.bind(view).apply {
            initUi()
        }
    }

    private fun FragmentEx3Binding.initUi() {
        btnCountSeconds.setOnClickListener { countIterations() }
    }

    private fun FragmentEx3Binding.countIterations() {
        btnCountSeconds.isEnabled = false

        thread(start = true) {
            for (i in 1..SECONDS_TO_COUNT) {
                mUiHandler.post { txtCount.text = i.toString() }
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    return@thread
                }
            }

            mUiHandler.post {
                txtCount.text = "Done!"
                btnCountSeconds.isEnabled = true
            }
        }
    }

}