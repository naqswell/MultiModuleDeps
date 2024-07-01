package com.example.feature2.internal.common.di

import com.example.feature2.internal.utils.InternalLogger
import com.example.feature2.internal.utils.InternalLoggerImpl
import dagger.Binds
import dagger.Module

@Module
internal interface FeatureArgsConsumerModule {
    @Binds
    fun bindInternalLogger(impl: InternalLoggerImpl): InternalLogger
}