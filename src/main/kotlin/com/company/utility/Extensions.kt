package com.company.utility

import kotlin.random.Random


fun Int.isChance(): Boolean {
    val result = Random.nextInt(0, 101)
    return result <= this
}