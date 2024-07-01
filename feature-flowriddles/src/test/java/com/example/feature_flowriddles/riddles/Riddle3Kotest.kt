package com.example.feature_flowriddles.riddles

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList

class Riddle3Kotest: StringSpec({
    "it should emit only not odd numbers" {
        val givenFlow = flowOf(-2, -1, 0, 1, 2, 3, 4, 5)
        val expectedResult = listOf(-2, 0, 2, 4)
        val result = Riddle3.solve(givenFlow).toList()

        result shouldBe expectedResult
    }
})