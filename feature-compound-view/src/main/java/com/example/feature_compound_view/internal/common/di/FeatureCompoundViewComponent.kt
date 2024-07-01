package com.example.feature_compound_view.internal.common.di

import com.example.feature_compound_view.api.FeatureCompoundViewDependencies
import com.example.feature_compound_view.api.FeatureCompoundViewFragment
import dagger.Component

@Component(
    modules = [FeatureCompoundViewModule::class],
    dependencies = [FeatureCompoundViewDependencies::class]
)
interface FeatureCompoundViewComponent {

    fun inject(fragment: FeatureCompoundViewFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: FeatureCompoundViewDependencies): FeatureCompoundViewComponent
    }
}