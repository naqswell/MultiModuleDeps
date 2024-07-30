package com.example.feature_threads.internal.screenflows.uithread.customhandler

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.feature_threads.R
import com.example.feature_threads.databinding.FragmentCustomHandlerBinding
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingDeque
import kotlin.concurrent.thread

class CustomHandlerFragment: Fragment(R.layout.fragment_custom_handler) {

    companion object {
        fun newInstance(): Fragment = CustomHandlerFragment().apply {}
        private const val SECONDS_TO_COUNT: Int = 5
    }

    private val mCustomHandler: CustomHandler by lazy { CustomHandler() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentCustomHandlerBinding.bind(view).apply {
            initUi()
        }
    }

    override fun onStart() {
        super.onStart()
        mCustomHandler.start()
    }

    override fun onStop() {
        super.onStop()
        mCustomHandler.stop()
    }

    private fun FragmentCustomHandlerBinding.initUi() {
        btnSendJob.setOnClickListener {

            mCustomHandler.post(
                Runnable {
                    for (i in 0 until SECONDS_TO_COUNT) {
                        try {
                            Thread.sleep(1000)
                        } catch (e: InterruptedException) {
                            return@Runnable
                        }
                        Log.d("CustomHandler", "iteration: $i")
                    }
                }
            )

        }
    }

    private class CustomHandler {
        private val POISON = Runnable {}
        private val mQueue: BlockingQueue<Runnable> = LinkedBlockingDeque()

        fun start() {
            thread(start = true) {
                while (true) {
                    var runnable: Runnable
                    try {
                        runnable = mQueue.take()
                    } catch (e: InterruptedException) {
                        return@thread
                    }
                    if (runnable === POISON) {
                        Log.d("CustomHandler", "poison data detected; stopping working thread")
                        return@thread
                    }
                    runnable.run()
                }
            }
        }

        fun post(job: Runnable) {
            mQueue.add(job)
        }

        fun stop() {
            mQueue.clear()
            mQueue.add(POISON)
        }
    }

}