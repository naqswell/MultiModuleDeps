package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Riddle2Test {

    @Test
    fun `Should be incremented by 1`() = runTest {
        val givenFlow = flowOf(0, -1, 6)
        val expectedResult = listOf(1, 0, 7)
        val result = Riddle2.solve(givenFlow).toList()

        assertEquals(result, expectedResult)
    }
}