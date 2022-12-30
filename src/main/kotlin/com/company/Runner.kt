package com.company

import com.company.service.Battle

fun main() {

    val t = getKeyboardInput(
        latMessage = { print("Введите количество воинов в командах: ") },
        secondMessage = { println("ERROR  -> Введите данные, согласно условию") }
    )
    val battle = Battle(t)

    battle.battle()

}

fun getKeyboardInput(
    limitLoop: Int = 30,
    latMessage: ((limit: Int) -> Unit)? = null,
    secondMessage: ((limit: Int) -> Unit)? = null
): Int {
    var i = 0
    while (i <= 0 || i > limitLoop) {
        latMessage?.invoke(limitLoop)
        i = readln().toIntOrNull() ?: 0
        if (i <= 0 || i > limitLoop) {
            secondMessage?.invoke(limitLoop)
        } else {
            return i
        }
    }
    return 0
}