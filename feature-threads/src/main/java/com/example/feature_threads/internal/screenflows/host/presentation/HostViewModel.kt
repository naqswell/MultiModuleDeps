package com.example.feature_threads.internal.screenflows.host.presentation

import androidx.lifecycle.ViewModel
import com.example.feature_threads.internal.navigation.ScreenNavigator
import javax.inject.Inject

class HostViewModel @Inject constructor(
): ViewModel() {

    private var screenNavigator: ScreenNavigator? = null

    fun configure(screenNavigator: ScreenNavigator) {
        this.screenNavigator = screenNavigator
    }

    fun onCustomHandlerScreen() {
        screenNavigator?.onCustomHandlerScreen()
    }

    fun onExercise1Screen() {
        screenNavigator?.onExercise1Screen()
    }

    fun onExercise2Screen() {
        screenNavigator?.onExercise2Screen()
    }

    fun onExercise3Screen() {
        screenNavigator?.onExercise3Screen()
    }

    fun onExercise4Screen() {
        screenNavigator?.onExercise4Screen()
    }
}