package com.company.utility

interface Warrior {
    var isKilled: Boolean //убитый
    val dexterity: Int    //шанс избежать попадания
    val currentHp: Double
    fun attack(warrior: Warrior?)
    fun acceptedDamage(damage: Double)
    fun getRang():Int

}