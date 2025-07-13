package com.example.feature2.internal.common.di

import com.example.feature2.api.FeatureArgsConsumerDependencies
import com.example.feature2.api.FeatureArgsConsumerFragment
import com.example.feature2.internal.presentation.FeatureArgsConsumerViewModel
import dagger.Component

@Component(
    modules = [FeatureArgsConsumerModule::class],
    dependencies = [FeatureArgsConsumerDependencies::class]
)
internal interface FeatureArgsConsumerComponent {
    val viewModelFactory: FeatureArgsConsumerViewModel.Factory

    fun inject(fragment: FeatureArgsConsumerFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: FeatureArgsConsumerDependencies): FeatureArgsConsumerComponent
    }
}