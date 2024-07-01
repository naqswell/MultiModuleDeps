package com.example.multiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.core.common.DepsMap
import com.example.core.common.HasDependencies
import com.example.core.presentation.ContainerId
import com.example.feature1.api.FeatureMainFragment
import com.example.multiapp.databinding.ActivityMainBinding
import com.example.multiapp.di.activity.MainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasDependencies {

    @Inject override lateinit var depsMap: DepsMap
    @Inject lateinit var containerId: ContainerId

    private val mainActivityComponent: MainActivityComponent by lazy {
        appComponent.mainActivityComponentFactory().create(
            activityContext = this@MainActivity,
            fragmentManager = supportFragmentManager,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent.inject(this@MainActivity)
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(containerId.value, FeatureMainFragment.newInstance())
            }
        }
    }
}