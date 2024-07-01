package com.example.core_dagger

import com.example.core.common.Dependencies
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class DependenciesKey(val value: KClass<out Dependencies>)
