package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class Riddle9Test {

    @Test
    fun `Should throw IllegalArgumentException when value is null`() = runTest {
        val givenValue: Int? = null

        assertThrows<IllegalArgumentException> {
            Riddle9.solve(givenValue).first()
        }
    }

    @Test
    fun `Should emit value when is not null`() = runTest {
        val givenValue = 33

        val expected = listOf(33)

        val actual = Riddle9.solve(givenValue).toList()

        assertEquals(expected, actual)
    }
}