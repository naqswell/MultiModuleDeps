package com.example.feature_threads.internal.navigation

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.core.presentation.ContainerId
import com.example.feature_threads.internal.screenflows.basics.ex1_basics.Ex1BasicsFragment
import com.example.feature_threads.internal.screenflows.basics.ex2_stopping.Ex2StoppingFragment
import com.example.feature_threads.internal.screenflows.multithreading.ex4_fibonacci.Ex4FibonacciFragment
import com.example.feature_threads.internal.screenflows.uithread.customhandler.CustomHandlerFragment
import com.example.feature_threads.internal.screenflows.uithread.ex3.Ex3Fragment
import javax.inject.Inject

internal class ScreenNavigatorImpl @Inject constructor(
    private val fragmentManager: FragmentManager,
    private val containerId: ContainerId,
) : ScreenNavigator {

    override fun onCustomHandlerScreen() {
        fragmentManager.commit {
            replace(containerId.value, CustomHandlerFragment.newInstance())
            addToBackStack(null)
        }
    }

    override fun onExercise1Screen() {
        fragmentManager.commit {
            replace(containerId.value, Ex1BasicsFragment.newInstance())
            addToBackStack(null)
        }
    }

    override fun onExercise2Screen() {
        fragmentManager.commit {
            replace(containerId.value, Ex2StoppingFragment.newInstance())
            addToBackStack(null)
        }
    }

    override fun onExercise3Screen() {
        fragmentManager.commit {
            replace(containerId.value, Ex3Fragment.newInstance())
            addToBackStack(null)
        }
    }

    override fun onExercise4Screen() {
        fragmentManager.commit {
            replace(containerId.value, Ex4FibonacciFragment.newInstance())
            addToBackStack(null)
        }
    }

}