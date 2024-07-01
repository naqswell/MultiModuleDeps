package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object Riddle5 {
    /**
     * Implement toggle mechanism.
     * Initially return [initialValue],
     * then each time [source] emits value,
     * negate value previously emitted by your Flow.
     */
    fun solve(initialValue: Boolean, source: Flow<Unit>): Flow<Boolean>  = flow {
        var current = initialValue
        emit(current)

        source.collect {
            current = !current
            emit(current)
        }
    }
}