package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object Riddle1 {
    /**
     * Transform the given [value] into an Flow that emits the value and then completes.
     *
     * Use case: You want to transform some value to the Kotlin Flow world.
     */
    fun solve(value: Int): Flow<Int> = flowOf(value)
}