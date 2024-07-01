package com.example.feature_threads.internal.di

import androidx.fragment.app.FragmentManager
import com.example.feature_threads.api.FeatureThreadsDependencies
import com.example.feature_threads.api.FeatureThreadsFragment
import com.example.feature_threads.internal.screenflows.host.HostFragmentDependencies
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        FeatureThreadsModule::class,
        HostFragmentDependenciesModule::class
    ],
    dependencies = [FeatureThreadsDependencies::class]
)
interface FeatureThreadsComponent : HostFragmentDependencies {

    fun inject(fragment: FeatureThreadsFragment)

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: FeatureThreadsDependencies,
            @BindsInstance fragmentManager: FragmentManager
        ): FeatureThreadsComponent
    }
}