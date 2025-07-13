package com.example.feature_threads.internal.screenflows.basics.ex2_stopping

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.feature_threads.R
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread

internal class Ex2StoppingFragment : Fragment(R.layout.fragment_ex2_stopping) {

    private val mDummyData = ByteArray(50 * 1000 * 1000)
    private val countScreenTimeFlag = AtomicBoolean(true)

    override fun onStart() {
        super.onStart()
        countScreenTimeFlag.set(true)
        countScreenTime()
    }

    override fun onStop() {
        super.onStop()
        countScreenTimeFlag.set(false)
    }

    private fun countScreenTime() {
        thread {
            var screenTimeInSeconds: Int = 0

            while (countScreenTimeFlag.get()) {
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    return@thread
                }
                screenTimeInSeconds += 1
                Log.d("Exercise 2", "screen time: " + screenTimeInSeconds + "s")
            }
        }
    }

    companion object {
        fun newInstance(): Fragment =
            Ex2StoppingFragment().apply { }
    }

}