package com.example.feature_flowriddles.examples.flatMapMerge

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlin.random.Random

/* Пример как заменить await логику с обычной корутиной */

data class Category(val value: Int)
data class Offer(val value: Int)

class Api {
    suspend fun requestOffers(category: Category): List<Offer> {
        val list = mutableListOf<Offer>()
        val count = Random.nextInt(1, 10)

        for(i in 0..count) {
            list.add(Offer(Random.nextInt()))
        }
        return list
    }
}

object Example {
    private val api = Api()

    suspend fun getOffers(
        categories: List<Category>
    ): List<Offer> = coroutineScope {
        categories
            .map { category -> async { api.requestOffers(category) } }
            .flatMap { it.await() }
    }
}

object ExampleBetterSolution {
    private val api = Api()
    
    fun getOffers(
        categories: List<Category>
    ): Flow<Offer> = categories
        .asFlow()
        .flatMapMerge(concurrency = 20) {
            api.requestOffers(it).asFlow()
        }
}

suspend fun main() {
    val categories = listOf(Category(1), Category(2), Category(3))

//    coroutineScope {
//        val offers = Example.getOffers(categories)
//        offers.forEach {
//            println(it)
//        }
//    }

    ExampleBetterSolution.getOffers(categories).collect {
        println(it)
    }
}