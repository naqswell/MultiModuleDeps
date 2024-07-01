package com.example.feature_flowriddles.riddles

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Riddle8Test {

    @Test
    fun `Should return value that flow emits`() = runTest {
        val givenFlow = flowOf(22)
        val givenDefaultValue = 117

        val expected = listOf(22)

        val actual = Riddle8.solve(givenDefaultValue, givenFlow).toList()

        assertEquals(expected, actual)
    }

    @Test
    fun `Should return default value when flow emits error`() = runTest {
        val givenFlow = flow<Int> {
            throw Error()
        }

        val givenDefaultValue = 1

        val expected = listOf(1)

        val actual = Riddle8.solve(givenDefaultValue, givenFlow).toList()

        assertEquals(expected, actual)
    }

}