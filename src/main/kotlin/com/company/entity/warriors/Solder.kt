package com.company.entity.warriors

import com.company.abstracts.AbstractWarrior
import com.company.abstracts.AbstractWeapon

class Solder(
    maxLevelHp: Double,
    dexterityArg: Int,
    accuracy: Int,
    weapon: AbstractWeapon,
    rang: Int
) : AbstractWarrior(maxLevelHp, dexterityArg, accuracy, weapon, rang) {
    override fun toString(): String = "The \"Solder\" HP:$currentHp," +
            " current ammo in clip:${weapon.currentAmmoInClip}"
}