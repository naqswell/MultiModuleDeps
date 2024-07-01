package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.sample

object Riddle12 {
    /**
     * Let the first emission of the [source] within a time window of 300ms travel downstream
     * but don't emit any other events until the next time window.
     * Use case: prevent double click on button
     */
    fun solve(source: Flow<Unit>): Flow<Unit> = source.sample(300)
}