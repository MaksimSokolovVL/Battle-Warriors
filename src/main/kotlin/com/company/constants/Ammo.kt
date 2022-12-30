package com.company.constants

import com.company.utility.isChance

enum class Ammo(
    private val damage: Double,
    private val criticalDamageChance: Int,
    private val criticalDamageCoefficient: Double
) {
    STANDARD(
        damage = 5.0,
        criticalDamageChance = 30,
        criticalDamageCoefficient = 1.75
    ),
    INCENDIARY(
        7.0,
        25,
        2.5
    ),
    PIERCING(
        5.0,
        45,
        1.25
    ),
    EXPLOSIVE(
        12.0,
        15,
        3.0
    );

    fun getDamage(): Double {
        return if (criticalDamageChance.isChance()) {
              damage * criticalDamageCoefficient
        } else
             damage
    }
}