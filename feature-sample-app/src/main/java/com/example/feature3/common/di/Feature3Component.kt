package com.example.feature3.common.di

import com.example.feature3.api.Feature3Dependencies
import com.example.feature3.api.FeatureSampleAppFragment
import dagger.Component

@Component(
    modules = [Feature3Module::class],
    dependencies = [Feature3Dependencies::class]
)
interface Feature3Component {
    fun inject(fragment: FeatureSampleAppFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: Feature3Dependencies): Feature3Component
    }

}