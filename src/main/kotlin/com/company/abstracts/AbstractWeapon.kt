package com.company.abstracts

import com.company.constants.Ammo
import com.company.utility.FireType
import com.company.utility.Stack

abstract class AbstractWeapon(
    private val maxSizeAmmo: Int,
    private val fireType: FireType,
    private val typeAmmunition: Ammo,
    private val ammunitionClip: Stack<Ammo>,
    isEmptyAmmoArg: Boolean = true
) {
    var isEmptyAmmo = isEmptyAmmoArg
        private set
    var currentAmmoInClip: Int = 0
        private set

    private fun creatingAmmunition(): Ammo {
//        println("new patron")
        return Ammo.valueOf(typeAmmunition.toString())
    }

    fun reload(): Stack<Ammo> {
        println("reload")
        while (currentAmmoInClip != maxSizeAmmo) {
            val patron = creatingAmmunition()
            ammunitionClip.push(patron)
            currentAmmoInClip++
        }
        isEmptyAmmo = false
        return ammunitionClip
    }

    fun getAmmoForShot(): List<Ammo> {

        val resultAmmoFire = mutableListOf<Ammo>()
        when (fireType) {
            is FireType.OneShot -> {
                println("bang")
                resultAmmoFire.add(ammunitionClip.pop())
                currentAmmoInClip--
            }
            is FireType.Burst -> {
                for (i in 0..FireType.Burst().countFire + 1) {
                    if (currentAmmoInClip != 0) {
                        println("bang${i + 1}")
                        resultAmmoFire.add(ammunitionClip.pop())
                        currentAmmoInClip--
                    } else {
                        continue
                    }
                }
            }
        }
        checkEmptyAmmo()
        return resultAmmoFire.toList()
    }

    private fun checkEmptyAmmo() {
        if (currentAmmoInClip <= 0) isEmptyAmmo = true
        if (currentAmmoInClip > 1) isEmptyAmmo = false
    }
}





