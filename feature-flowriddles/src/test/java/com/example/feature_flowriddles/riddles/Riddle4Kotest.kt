package com.example.feature_flowriddles.riddles

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList

class Riddle4Kotest : StringSpec({
    "it should to transform some collection of values to the Flow " +
            "emits the all values from [list] and then completes" {
                val givenList = listOf(1, 2, 3, 4)

                val expectedResult = flowOf(1, 2, 3, 4).toList()
                val result = Riddle4.solve(givenList).toList()

                result shouldBe expectedResult
            }
})