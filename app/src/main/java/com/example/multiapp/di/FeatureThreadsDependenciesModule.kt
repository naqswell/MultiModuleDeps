package com.example.multiapp.di

import com.example.core.common.Dependencies
import com.example.core_dagger.DependenciesKey
import com.example.feature_threads.api.FeatureThreadsDependencies
import com.example.multiapp.di.activity.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FeatureThreadsDependenciesModule {

    @[Binds IntoMap]
    @DependenciesKey(FeatureThreadsDependencies::class)
    fun bindFeatureThreadDeps(impl: MainActivityComponent): Dependencies
}