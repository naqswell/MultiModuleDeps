package com.example.multiapp.di.activity

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.example.feature1.api.FeatureMainDependencies
import com.example.feature2.api.FeatureArgsConsumerDependencies
import com.example.feature_compound_view.api.FeatureCompoundViewDependencies
import com.example.feature_threads.api.FeatureThreadsDependencies
import com.example.multiapp.MainActivity
import com.example.multiapp.di.Feature3DependenciesModule
import com.example.multiapp.di.FeatureArgsConsumerDependenciesModule
import com.example.multiapp.di.FeatureCompoundViewDependenciesModule
import com.example.multiapp.di.FeatureMainDependenciesModule
import com.example.multiapp.di.FeatureThreadsDependenciesModule
import com.example.multiapp.di.activity.qualifiers.ActivityContext
import dagger.BindsInstance
import dagger.Subcomponent

@MainActivityScope
@Subcomponent(
    modules = [
        MainActivityModule::class,
        FeatureMainDependenciesModule::class,
        FeatureArgsConsumerDependenciesModule::class,
        FeatureCompoundViewDependenciesModule::class,
        FeatureThreadsDependenciesModule::class,
        Feature3DependenciesModule::class,
    ]
)
interface MainActivityComponent :
    FeatureMainDependencies,
    FeatureArgsConsumerDependencies,
    FeatureCompoundViewDependencies,
    FeatureThreadsDependencies {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext activityContext: Context,
            @BindsInstance fragmentManager: FragmentManager,
        ): MainActivityComponent
    }
}