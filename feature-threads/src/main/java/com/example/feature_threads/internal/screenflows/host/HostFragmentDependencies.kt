package com.example.feature_threads.internal.screenflows.host

import com.example.core.common.Dependencies
import com.example.feature_threads.internal.navigation.ScreenNavigator

interface HostFragmentDependencies: Dependencies {
    val screenNavigator: ScreenNavigator
}