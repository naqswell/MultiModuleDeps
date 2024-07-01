package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

object Riddle14 {
    /**
     * Create flow that will delay each element emitted by [source] by 10ms
     */

    fun solve(source: Flow<Int>): Flow<Int> = source.onEach {
        delay(10)
    }


    /* if you build your own flow:
        flow {
            source.collect {
                delay(10.milliseconds)
                emit(it)
            }
        }
    */
}