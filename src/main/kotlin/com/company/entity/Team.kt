package com.company.entity

import com.company.constants.WarriorTypes
import com.company.utility.Warrior
import com.company.utility.WarriorFactory
import kotlin.random.Random

class Team(private val numberWarriors: Int) {
    var list = mutableListOf<Warrior>()
    private fun createTeam() {
        var randomNumber: Int
        for (i in 1..numberWarriors) {
            randomNumber = Random.nextInt(0, 101)
            when (randomNumber) {
                in 0..11 -> list.add(WarriorFactory.getInstanceWarrior(WarriorTypes.GENERAL))
                in 11..31 -> list.add(WarriorFactory.getInstanceWarrior(WarriorTypes.CAPTAIN))
                in 31..60 -> list.add(WarriorFactory.getInstanceWarrior(WarriorTypes.SNIPER))
                else -> list.add(WarriorFactory.getInstanceWarrior(WarriorTypes.SOLDER))
            }
        }
    }

    init {
        createTeam()
        list.shuffle()
    }

}