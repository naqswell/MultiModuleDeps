package com.example.feature_threads.internal.navigation

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.core.presentation.ContainerId
import com.example.feature_threads.internal.screenflows.customhandler.CustomHandlerFragment
import javax.inject.Inject

class ScreenNavigatorImpl @Inject constructor(
    private val fragmentManager: FragmentManager,
    private val containerId: ContainerId,
) : ScreenNavigator {

    override fun onCustomHandlerScreen() {
        fragmentManager.commit {
            add(containerId.value, CustomHandlerFragment.newInstance())
            addToBackStack(null)
        }
    }

}