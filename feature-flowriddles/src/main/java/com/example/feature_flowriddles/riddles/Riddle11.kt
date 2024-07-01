package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapMerge

object Riddle11 {
    /**
     * For each item emitted by [source] create new flow using provided [transformation] and flatten the results.
     */
    fun solve(transformation: suspend (Int) -> Flow<String>, source: Flow<Int>): Flow<String> =
        source.flatMapMerge(transform = transformation)
}