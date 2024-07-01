package com.example.multiapp.di

import com.example.core.common.Dependencies
import com.example.core_dagger.DependenciesKey
import com.example.feature2.api.FeatureArgsConsumerDependencies
import com.example.multiapp.di.activity.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FeatureArgsConsumerDependenciesModule {

    @[Binds IntoMap]
    @DependenciesKey(FeatureArgsConsumerDependencies::class)
    fun bindFeatureArgsConsumerDeps(impl: MainActivityComponent): Dependencies
}