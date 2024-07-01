package com.example.multiapp.di

import com.example.core.common.Dependencies
import com.example.core_dagger.DependenciesKey
import com.example.feature_compound_view.api.FeatureCompoundViewDependencies
import com.example.multiapp.di.activity.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FeatureCompoundViewDependenciesModule {

    @[Binds IntoMap]
    @DependenciesKey(FeatureCompoundViewDependencies::class)
    fun bindFeatureCompoundViewDeps(impl: MainActivityComponent): Dependencies

}