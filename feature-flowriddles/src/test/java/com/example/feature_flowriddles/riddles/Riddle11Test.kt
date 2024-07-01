package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import org.junit.jupiter.api.Test

class Riddle11Test {

    @Test
    fun `Should create flow using transformation and flatten for each emitted item`() {
        val givenFlow = flowOf(1, 2, 3)

        val givenTransformation: suspend (value: Int) -> Flow<String> = {
            flow {
                emit("${it}_transformed")

            }
        }

        val expected = listOf(11, 12, 13, 14, 15, 16, 17, 18, 19)

        val actual = Riddle11.solve(givenTransformation, givenFlow)
    }
}