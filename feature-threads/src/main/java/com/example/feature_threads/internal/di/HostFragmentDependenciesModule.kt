package com.example.feature_threads.internal.di

import com.example.core.common.Dependencies
import com.example.core_dagger.DependenciesKey
import com.example.feature_threads.internal.screenflows.host.HostFragmentDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface HostFragmentDependenciesModule {

    @[Binds IntoMap]
    @DependenciesKey(HostFragmentDependencies::class)
    fun bindHostFragmentDeps(impl: FeatureThreadsComponent): Dependencies
}