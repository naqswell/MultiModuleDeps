package com.example.multiapp

import android.app.Application
import android.content.Context
import com.example.core.common.DepsMap
import com.example.core.common.HasDependencies
import com.example.multiapp.di.app.AppComponent
import com.example.multiapp.di.app.DaggerAppComponent
import javax.inject.Inject

class App: Application(), HasDependencies {

    @Inject override lateinit var depsMap: DepsMap

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(context = this@App)
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }