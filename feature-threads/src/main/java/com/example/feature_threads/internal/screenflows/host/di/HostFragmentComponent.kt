package com.example.feature_threads.internal.screenflows.host.di

import com.example.feature_threads.internal.screenflows.host.HostFragment
import com.example.feature_threads.internal.screenflows.host.HostFragmentDependencies
import dagger.Component

@Component(
    modules = [HostFragmentModule::class],
    dependencies = [HostFragmentDependencies::class]
)
interface HostFragmentComponent {

    fun inject(fragment: HostFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: HostFragmentDependencies): HostFragmentComponent
    }

}