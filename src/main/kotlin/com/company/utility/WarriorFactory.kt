package com.company.utility

import com.company.constants.WarriorTypes
import com.company.entity.*
import com.company.entity.warriors.Captain
import com.company.entity.warriors.General
import com.company.entity.warriors.Sniper
import com.company.entity.warriors.Solder

object WarriorFactory {
    fun getInstanceWarrior(constantTypeWarrior: WarriorTypes): Warrior {
        if (!enumValues<WarriorTypes>().contains(constantTypeWarrior)) {
            System.err.print("Ошибка в фабрике, метод getInstanceWarrior")
        }
        return when (constantTypeWarrior) {
            WarriorTypes.SOLDER -> Solder(130.0, 5, 80, Weapons.createMachineGun(), 101)
            WarriorTypes.CAPTAIN -> Captain(180.0, 7, 90, Weapons.createPistol(),30)
            WarriorTypes.SNIPER -> Sniper(100.0, 7, 95, Weapons.createRifle(),50)
            WarriorTypes.GENERAL -> General(200.0, 15, 75, Weapons.createHandGrenadeLauncher(),10)
        }
    }
}


