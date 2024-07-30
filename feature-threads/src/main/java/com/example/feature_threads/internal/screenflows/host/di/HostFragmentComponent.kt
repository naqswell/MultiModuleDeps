package com.example.feature_threads.internal.screenflows.host.di

import com.example.feature_threads.internal.navigation.ScreenNavigator
import com.example.feature_threads.internal.screenflows.host.HostFragmentDependencies
import com.example.feature_threads.internal.screenflows.host.presentation.HostFragment
import com.example.feature_threads.internal.screenflows.host.presentation.HostViewModel
import dagger.Component

@Component(
    modules = [HostFragmentModule::class],
    dependencies = [HostFragmentDependencies::class]
)
interface HostFragmentComponent {
    val viewModel: HostViewModel
    val screenNavigator: ScreenNavigator

    fun inject(fragment: HostFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: HostFragmentDependencies): HostFragmentComponent
    }

}