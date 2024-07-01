package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Riddle10Test {

    @Test
    fun `Should emit n values and then complete`() = runTest {
        val givenN = 4

        val expected = 4
        val actual = Riddle10.solve(givenN).toList().size

        assertEquals(expected, actual)
    }
}