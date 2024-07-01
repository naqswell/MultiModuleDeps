package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

object Riddle8 {
    /**
     * Given [source] emits value, emit that value
     * Given [source] emits [Error], emit default value
     */
    fun solve(defaultValue: Int, source: Flow<Int>): Flow<Int> =
        source.catch {
            emit(defaultValue)
        }
}