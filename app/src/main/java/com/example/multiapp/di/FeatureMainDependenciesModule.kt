package com.example.multiapp.di

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.core.common.Dependencies
import com.example.core.presentation.ContainerId
import com.example.core_dagger.DependenciesKey
import com.example.feature1.api.FeatureMainDependencies
import com.example.feature1.api.OtherFeaturesCommunicator
import com.example.feature2.api.FeatureArgsConsumerFragment
import com.example.feature_compound_view.api.FeatureCompoundViewFragment
import com.example.feature_threads.api.FeatureThreadsFragment
import com.example.multiapp.di.activity.MainActivityComponent
import com.example.multiapp.di.activity.MainActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface FeatureMainDependenciesModule {

    companion object {
        @Provides @MainActivityScope
        fun otherFeaturesFragmentCommunicator(
            fragmentManager: FragmentManager, containerId: ContainerId
        ): OtherFeaturesCommunicator = object : OtherFeaturesCommunicator {
            override fun onOpenFeatureArgs(id: Int, additional: String) =
                fragmentManager.commit {
                    replace(
                        containerId.value,
                        FeatureArgsConsumerFragment.newInstance(id = id, additional = additional)
                    )
                    addToBackStack(null)
                }

            override fun onOpenFeatureCompoundView() = fragmentManager.commit {
                replace(containerId.value, FeatureCompoundViewFragment.newInstance())
                addToBackStack(null)
            }

            override fun onOpenFeatureThreads() = fragmentManager.commit {
                replace(containerId.value, FeatureThreadsFragment.newInstance().also {
                    setPrimaryNavigationFragment(it)
                })
                addToBackStack(null)
            }
        }
    }

    @[Binds IntoMap]
    @DependenciesKey(FeatureMainDependencies::class)
    fun bindFeature1Deps(impl: MainActivityComponent): Dependencies
}