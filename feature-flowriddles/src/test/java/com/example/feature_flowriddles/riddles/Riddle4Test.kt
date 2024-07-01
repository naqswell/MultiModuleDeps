package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Riddle4Test {

    @Test
    fun `Should emit all values and completes`() = runTest {
        val givenList = listOf(1, 2, 3, 4, 5)

        val expectedResult = flowOf(1, 2, 3, 4, 5).toList()
        val result = Riddle4.solve(givenList).toList()

        assertEquals(expectedResult, result)
    }

}