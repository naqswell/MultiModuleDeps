package com.example.multiapp.di.activity

import com.example.core.presentation.ContainerId
import com.example.multiapp.R
import dagger.Module
import dagger.Provides

@Module
interface MainActivityModule {

    companion object {
        @Provides
        fun containerId(): ContainerId = ContainerId(R.id.features_container)
    }

}