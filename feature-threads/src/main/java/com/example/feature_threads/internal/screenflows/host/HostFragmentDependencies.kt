package com.example.feature_threads.internal.screenflows.host

import com.example.core.common.Dependencies
import com.example.feature_threads.internal.navigation.ScreenNavigator

internal interface HostFragmentDependencies: Dependencies {
    val screenNavigator: ScreenNavigator
}