package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object Riddle9 {
    /**
     * Given [value] is null, throw [IllegalArgumentException]
     * Given [value] is not null, emit that value
     */
    fun solve(value: Int?): Flow<Int> =
        flow {
            value?.let { emit(value) } ?: throw IllegalArgumentException()
        }
}