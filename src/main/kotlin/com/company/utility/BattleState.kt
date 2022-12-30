package com.company.utility

import com.company.entity.Team

sealed class BattleState {
    class Process(private val team1: Team, private val team2: Team) : BattleState() {
        private var sumHpOneTeams = 0.0
        private var sumHpTowTeams = 0.0
        private var lifeWarriorsOneTeams = 0
        private var lifeWarriorsTowTeams = 0

        fun teamsInfo() {
            team1.list.forEach { warrior -> sumHpOneTeams += warrior.currentHp }
            team2.list.forEach { warrior -> sumHpTowTeams += warrior.currentHp }
            lifeWarriorsOneTeams = getLifeWarriorsTeams(team1)
            lifeWarriorsTowTeams = getLifeWarriorsTeams(team2)

            val result = """Teams One: count life warriors:$lifeWarriorsOneTeams, all HP:$sumHpOneTeams
               |Teams Two: count life warriors:$lifeWarriorsTowTeams, all HP:$sumHpTowTeams
           """.trimMargin()
            println(result)
        }
    }

    class WinOneTeam(massage: String) : BattleState() {init {
        println("$massage\uD83C\uDF87 \uD83C\uDF87 \uD83C\uDF87")
    }
    }

    class WinTowTeam(massage: String) : BattleState() {init {
        println("$massage\uD83C\uDF87 \uD83C\uDF87 \uD83C\uDF87")
    }
    }

    fun getLifeWarriorsTeams(team: Team): Int {
        var lifeWarriorsTeams = 0
        team.list.forEach { warrior -> if (!warrior.isKilled) lifeWarriorsTeams++ }
        return lifeWarriorsTeams
    }
}
