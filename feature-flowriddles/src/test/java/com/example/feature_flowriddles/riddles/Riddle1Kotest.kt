package com.example.feature_flowriddles.riddles

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.toList

class Riddle1Kotest : StringSpec({
    "it should transform given value to flow and then complete" {
        val givenValue = 3
        val result = Riddle1.solve(givenValue).toList()
        result shouldBe listOf(givenValue)
    }
})