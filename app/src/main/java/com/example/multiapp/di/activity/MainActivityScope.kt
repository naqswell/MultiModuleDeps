package com.example.multiapp.di.activity

import javax.inject.Scope

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION
)
@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class MainActivityScope