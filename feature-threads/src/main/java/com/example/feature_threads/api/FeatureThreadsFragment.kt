package com.example.feature_threads.api

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.core.common.DepsMap
import com.example.core.common.HasDependencies
import com.example.core.common.findDependencies
import com.example.core.presentation.ContainerId
import com.example.feature_threads.R
import com.example.feature_threads.databinding.FragmentFeatureThreadsBinding
import com.example.feature_threads.internal.di.DaggerFeatureThreadsComponent
import com.example.feature_threads.internal.screenflows.host.presentation.HostFragment
import javax.inject.Inject

class FeatureThreadsFragment : Fragment(R.layout.fragment_feature_threads), HasDependencies {

    @Inject override lateinit var depsMap: DepsMap
    @Inject lateinit var containerId: ContainerId

    override fun onAttach(context: Context) {
        DaggerFeatureThreadsComponent
            .factory()
            .create(
                dependencies = findDependencies(),
                fragmentManager = childFragmentManager
            ).also {
                it.inject(this@FeatureThreadsFragment)
            }
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentFeatureThreadsBinding.bind(view)

        if (savedInstanceState == null) {
            childFragmentManager.commit {
                replace(containerId.value, HostFragment.newInstance())
            }
        }
    }

    fun initBackHandlerForActivity() {
        requireActivity().onBackPressedDispatcher.addCallback {
            if (childFragmentManager.backStackEntryCount > 0) childFragmentManager.popBackStack()
            this.remove()
        }
    }

    companion object {
        fun newInstance(): Fragment = FeatureThreadsFragment().apply { }
    }

}