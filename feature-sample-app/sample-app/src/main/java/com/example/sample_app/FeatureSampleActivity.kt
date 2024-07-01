package com.example.sample_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.core.common.DepsMap
import com.example.core.common.HasDependencies
import com.example.core.utils.SystemLogger
import com.example.feature3.api.Feature3Dependencies
import com.example.feature3.api.FeatureSampleAppFragment

class FeatureSampleActivity : AppCompatActivity(), HasDependencies {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_sample_app)

        supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_fragment, FeatureSampleAppFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }


    override val depsMap: DepsMap = mapOf(
        Feature3Dependencies::class.java to object : Feature3Dependencies {
            override val systemLogger: SystemLogger = object : SystemLogger {
                override fun getStatus(): String = "Feature3SampleLogger"
            }
        }
    )
}