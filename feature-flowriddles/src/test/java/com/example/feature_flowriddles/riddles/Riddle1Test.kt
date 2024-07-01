package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Riddle1Test {

    @Test
    fun `Should be same value`() = runTest {
        val givenValue = 3
        val result = Riddle1.solve(givenValue).toList()

        assertEquals(listOf(givenValue), result)
    }

}