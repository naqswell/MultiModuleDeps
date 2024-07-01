package com.example.feature1.internal.common.di

import com.example.feature1.api.FeatureMainDependencies
import com.example.feature1.api.FeatureMainFragment
import com.example.feature1.api.OtherFeaturesCommunicator
import com.example.feature1.internal.common.presentation.FeatureMainViewModel
import dagger.Component

@Component(
    modules = [FeatureMainModule::class],
    dependencies = [FeatureMainDependencies::class]
)
interface FeatureMainComponent {
    val viewModel: FeatureMainViewModel
    val featuresCommunicator: OtherFeaturesCommunicator

    fun inject(fragment: FeatureMainFragment)

    @Component.Factory
    interface Factory {

        fun create(dependencies: FeatureMainDependencies): FeatureMainComponent
    }
}