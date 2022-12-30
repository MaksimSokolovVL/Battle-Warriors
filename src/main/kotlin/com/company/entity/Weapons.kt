package com.company.entity

import com.company.abstracts.AbstractWeapon
import com.company.constants.Ammo
import com.company.utility.FireType
import com.company.utility.Stack

object Weapons {

    fun createPistol(): AbstractWeapon {
//        println("new pistol")
        return object : AbstractWeapon(
            maxSizeAmmo = 12,
            fireType = FireType.OneShot,
            typeAmmunition = Ammo.STANDARD,
            ammunitionClip = Stack(),
        ) {}
    }

    fun createRifle(): AbstractWeapon {
//        println("new rifle")
        return object : AbstractWeapon(
            maxSizeAmmo = 23,
            fireType = FireType.OneShot,
            typeAmmunition = Ammo.INCENDIARY,
            ammunitionClip = Stack()
        ) {}
    }

    fun createMachineGun(): AbstractWeapon {
//        println("new machine Gun")
        return object : AbstractWeapon(
            maxSizeAmmo = 45,
            fireType = FireType.Burst(5),
            typeAmmunition = Ammo.PIERCING,
            ammunitionClip = Stack()
        ) {}
    }

    fun createHandGrenadeLauncher(): AbstractWeapon {
//        println("new Hand grenade launcher")
        return object : AbstractWeapon(
            maxSizeAmmo = 6,
            fireType = FireType.OneShot,
            typeAmmunition = Ammo.EXPLOSIVE,
            ammunitionClip = Stack()
        ) {}
    }
}