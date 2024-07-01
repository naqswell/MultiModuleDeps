package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter

object Riddle3 {
    /**
     * Don't emit odd numbers from the [source] Flow.
     *
     * Use case: You want to filter certain items out.
     */
    fun solve(source: Flow<Int>): Flow<Int> = source.filter { it % 2 == 0 }
}