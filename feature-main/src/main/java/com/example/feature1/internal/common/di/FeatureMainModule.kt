package com.example.feature1.internal.common.di

import com.example.feature1.internal.common.utils.InternalLogger
import com.example.feature1.internal.common.utils.InternalLoggerImpl
import dagger.Binds
import dagger.Module

@Module
internal interface FeatureMainModule {
    @Binds
    fun bindInternalLogger(impl: InternalLoggerImpl): InternalLogger
}