package com.example.feature_flowriddles.riddles

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList

class Riddle2Kotest : StringSpec({
    "it should increment each emitted value of the given source by 1 and complete" {
        val givenFlow = flowOf(0, -1, 6)
        val expectedResult = listOf(1, 0, 7)

        val result = Riddle2.solve(givenFlow).toList()

        result shouldBe expectedResult
    }
})
