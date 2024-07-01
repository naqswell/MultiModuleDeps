package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object Riddle13 {
    /**
     * Create flow that will emit next Int values from 0 to 20 with 20ms delay after each emission
     */
    fun solve(): Flow<Int> =
        flow {
            repeat(21) {
                emit(it)
                delay(20)
            }
        }
}