package com.example.multiapp.di.app

import android.content.Context
import com.example.multiapp.di.activity.MainActivityComponent
import com.example.multiapp.di.app.qualifier.AppContext
import dagger.BindsInstance
import dagger.Component


@ApplicationScope
@Component(
    modules = [
        AppModule::class,
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @AppContext context: Context,
        ): AppComponent
    }

    fun mainActivityComponentFactory(): MainActivityComponent.Factory

}