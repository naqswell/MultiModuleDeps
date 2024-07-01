package com.example.multiapp.di.app

import com.example.core.utils.SystemLogger
import com.example.core.utils.SystemLoggerImpl
import dagger.Module
import dagger.Provides

@Module
interface AppModule {

    companion object {
        @Provides @ApplicationScope
        fun providesSystemLogger(): SystemLogger = SystemLoggerImpl()
    }

}