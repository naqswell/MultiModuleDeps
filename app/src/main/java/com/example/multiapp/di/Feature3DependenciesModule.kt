package com.example.multiapp.di

import com.example.core.common.Dependencies
import com.example.core_dagger.DependenciesKey
import com.example.feature3.api.Feature3Dependencies
import com.example.multiapp.di.activity.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface Feature3DependenciesModule {

    @Binds
    @IntoMap
    @DependenciesKey(Feature3Dependencies::class)
    fun bindFeature3Deps(impl: MainActivityComponent): Dependencies
}