package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object Riddle10 {
    /**
     * Create Flow that will emit [n] values and then complete
     */
    fun solve(n: Int): Flow<Unit> =
        flow {
            repeat(n) {
                emit(Unit)
            }
        }
}