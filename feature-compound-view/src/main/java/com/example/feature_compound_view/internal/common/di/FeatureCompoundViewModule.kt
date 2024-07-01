package com.example.feature_compound_view.internal.common.di

import com.example.feature_compound_view.internal.utils.InternalLogger
import com.example.feature_compound_view.internal.utils.InternalLoggerImpl
import dagger.Binds
import dagger.Module

@Module
interface FeatureCompoundViewModule {
    @Binds
    fun bindInternalLogger(impl: InternalLoggerImpl): InternalLogger
}