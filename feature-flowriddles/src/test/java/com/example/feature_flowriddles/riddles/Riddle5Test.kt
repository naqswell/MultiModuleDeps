package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Riddle5Test {

    @Test
    fun `Should return initialValue then each time source emits value negate previous value `() =
        runTest {
            val givenSource = flowOf(Unit, Unit, Unit)
            val givenInitialValue = false

            val expected = listOf(false, true, false, true)
            val result = Riddle5.solve(givenInitialValue, givenSource).toList()
            assertEquals(expected, result)
        }
}