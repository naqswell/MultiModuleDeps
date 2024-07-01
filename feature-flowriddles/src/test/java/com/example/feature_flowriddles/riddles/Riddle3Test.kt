package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class Riddle3Test {

    @Test
    fun `Shouldn't emit odd values`() = runTest {
        val givenFlow = flowOf(-2, -1, 0, 1, 2, 3, 4, 5)

        val expectedResult = listOf(-2, 0, 2, 4)
        val result = Riddle3.solve(givenFlow).toList()

        assertEquals(expectedResult, result)
    }

}