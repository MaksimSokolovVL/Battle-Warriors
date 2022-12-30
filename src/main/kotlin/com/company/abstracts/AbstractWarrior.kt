package com.company.abstracts

import com.company.constants.Ammo
import com.company.utility.Warrior
import com.company.utility.isChance

abstract class AbstractWarrior(
    maxLevelHp: Double,
    dexterityArg: Int,     //шанс избежать попадания
    private val accuracy: Int,      //вероятность попадания
    protected val weapon: AbstractWeapon,
    private val rang: Int
) : Warrior {
    final override var currentHp = maxLevelHp
        private set
    final override var dexterity = dexterityArg
        private set
    final override var isKilled: Boolean = false

    override fun attack(warrior: Warrior?) {
        if (weapon.isEmptyAmmo) {
            weapon.reload()
        } else if (!isKilled) {
            val shotList = weapon.getAmmoForShot()
            var sumDamage = 0.0
            for (i in shotList.indices) {
                sumDamage += isShotOk(shotList[i])
            }

            if (warrior != null) {
                if (!warrior.isKilled) {
                    warrior.acceptedDamage(sumDamage)
                    println("Damage $sumDamage")
                }
            }
        }
    }

    override fun acceptedDamage(damage: Double) {
        val tempHP = currentHp - damage

        if (tempHP <= 0) {
            currentHp = 0.0
            isKilled = true
        } else {
            currentHp = tempHP
        }
    }

    private fun isShotOk(patron: Ammo): Double {
        if (!dexterity.isChance() && accuracy.isChance()) {
            return patron.getDamage()
        }
        return 0.0
    }

    override fun getRang(): Int {
        return rang
    }
}
