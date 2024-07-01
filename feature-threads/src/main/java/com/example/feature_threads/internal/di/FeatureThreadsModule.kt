package com.example.feature_threads.internal.di

import com.example.core.presentation.ContainerId
import com.example.feature_threads.R
import com.example.feature_threads.internal.navigation.ScreenNavigator
import com.example.feature_threads.internal.navigation.ScreenNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface FeatureThreadsModule {

    companion object {
        @Provides
        fun containerId(): ContainerId = ContainerId(R.id.threads_feature_container)
    }

    @Binds
    fun bindScreenNavigator(impl: ScreenNavigatorImpl): ScreenNavigator
}