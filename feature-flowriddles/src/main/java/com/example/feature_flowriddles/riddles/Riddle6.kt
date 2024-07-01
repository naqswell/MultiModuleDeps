package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.zip

object Riddle6 {
    /**
     * Combine two flows - sum corresponding values of [source1] and [source2].
     */
    fun solve(source1: Flow<Int>, source2: Flow<Int>): Flow<Int> = source1.zip(source2) { a, b ->
        a + b
    }
}