package com.example.feature_threads.internal.screenflows.multithreading.ex4_fibonacci

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.WorkerThread
import androidx.fragment.app.Fragment
import com.example.feature_threads.R
import com.example.feature_threads.databinding.FragmentEx4FibonacciBinding
import com.example.feature_threads.internal.screenflows.uithread.ex3.rangeTo
import java.math.BigInteger
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

internal class Ex4FibonacciFragment : Fragment(R.layout.fragment_ex4_fibonacci) {

    companion object {
        const val MAX_TIMEOUT_MS: Int = 1000

        fun newInstance(): Fragment = Ex4FibonacciFragment().apply {}
    }

    private var binding: FragmentEx4FibonacciBinding? = null
    private val mUiHandler = Handler(Looper.getMainLooper())

    @Volatile private var mAbortComputation = false
    private var mComputationTimeoutTime: Long? = null

    private var mNumberOfThreads = 0
    private var mThreadsComputationRanges = mutableListOf<ComputationRange>()
    @Volatile private var mThreadsComputationResults = mutableListOf<BigInteger?>()
    private var mNumOfFinishedThreads = AtomicInteger(0)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEx4FibonacciBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            initUi()
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onStop() {
        super.onStop()
        mAbortComputation = true
    }

    private fun FragmentEx4FibonacciBinding.initUi() {
        btnCompute.setOnClickListener {
            if (edtArgument.text.toString().isEmpty())
                return@setOnClickListener

            txtResult.text = ""
            btnCompute.isEnabled = false

            val imm =
                requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(btnCompute.windowToken, 0)

            val argument: Int = edtArgument.text.toString().toInt()

            val timeout = getTimeout() ?: return@setOnClickListener
            computeFactorial(argument, timeout)
        }
    }

    private fun computeFactorial(factorialArgument: Int, timeout: Int) {
        thread(start = true) {
            initComputationParams(factorialArgument, timeout)
            startComputation()
            waitForThreadsResultsOrTimeoutOrAbort()
            processComputationResults()
        }
    }

    private fun initComputationParams(factorialArgument: Int, timeout: Int) {
        mNumberOfThreads =
            if (factorialArgument < 20) 1
            else Runtime.getRuntime().availableProcessors()

        mNumOfFinishedThreads.set(0)
        mAbortComputation = false

        initThreadsComputationRanges(factorialArgument)

        mComputationTimeoutTime = System.currentTimeMillis() + timeout
    }

    private fun initThreadsComputationRanges(factorialArgument: Int) {
        val computationRangeSize = factorialArgument / mNumberOfThreads

        mThreadsComputationResults.clear()

        for (i in 0..computationRangeSize) {
            mThreadsComputationResults.add(null)
        }

        mThreadsComputationRanges.clear()
        var nextComputationRangeEnd = factorialArgument.toBigInteger()

        for (i in mNumberOfThreads - 1 downTo 0) {
            val newRangeItem = ComputationRange(
                nextComputationRangeEnd - computationRangeSize.toBigInteger() + 1.toBigInteger(),
                nextComputationRangeEnd
            )
            mThreadsComputationRanges.add(newRangeItem)
            nextComputationRangeEnd = newRangeItem.start - 1.toBigInteger()
        }
    }

    @WorkerThread
    private fun startComputation() {
        for (threadIndex in 0..<mNumberOfThreads) {

            thread(start = true) {
                val rangeStart = mThreadsComputationRanges[threadIndex].start
                val rangeEnd = mThreadsComputationRanges[threadIndex].end
                var product = BigInteger("1")
                for (num in rangeStart..rangeEnd) {
                    if (isTimedOut()) {
                        break
                    }
                    product = product.multiply(BigInteger(num.toString()))
                }
                mThreadsComputationResults[threadIndex] = product
                mNumOfFinishedThreads.incrementAndGet()
            }

        }
    }

    private fun isTimedOut(): Boolean {
        return System.currentTimeMillis() >= mComputationTimeoutTime!!
    }


    @WorkerThread
    private fun waitForThreadsResultsOrTimeoutOrAbort() {
        while (true) {
            when {
                mNumOfFinishedThreads.get() == mNumberOfThreads -> break
                mAbortComputation -> break
                isTimedOut() -> break
                else -> try {
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    // do nothing and keep looping
                }
            }
        }
    }


    @WorkerThread
    private fun processComputationResults() {
        var resultString: String

        resultString = if (mAbortComputation) {
            "Computation aborted"
        } else {
            computeFinalResult().toString()
        }

        // need to check for timeout after computation of the final result
        if (isTimedOut()) {
            resultString = "Computation timed out"
        }

        val finalResultString = resultString

        mUiHandler.post {
            if (!this@Ex4FibonacciFragment.isStateSaved()) {
                binding?.apply {
                    txtResult.text = finalResultString
                    btnCompute.setEnabled(true)
                }
            }
        }
    }

    @WorkerThread
    private fun computeFinalResult(): BigInteger {
        var result = BigInteger("1")
        for (i in 0 until mNumberOfThreads) {
            if (isTimedOut()) break
            val computationResults = mThreadsComputationResults[i] ?: break
            result = result.multiply(computationResults)
        }
        return result
    }

    private fun getTimeout(): Int? {
        binding?.apply {
            var timeout: Int
            if (edtTimeout.getText().toString().isEmpty()) {
                timeout =
                    MAX_TIMEOUT_MS
            } else {
                timeout = edtTimeout.getText().toString().toInt()
                if (timeout > MAX_TIMEOUT_MS) {
                    timeout = MAX_TIMEOUT_MS
                }
            }
            return timeout
        }
        return null
    }

    data class ComputationRange(
        val start: BigInteger,
        val end: BigInteger
    )

}