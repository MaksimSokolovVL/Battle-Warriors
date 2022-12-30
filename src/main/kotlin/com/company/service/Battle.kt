package com.company.service

import com.company.entity.Team
import com.company.utility.BattleState
import com.company.utility.Warrior
import java.util.concurrent.TimeUnit

class Battle(numberWarriorsInTeams: Int) {
    private var isBattleEnd = false
    private var isLifeTeam1 = true
    private var isLifeTeam2 = true
    private var team1 = Team(numberWarriorsInTeams)
    private var team2 = Team(numberWarriorsInTeams)

    private fun battleInfo() {
        BattleState.Process(team1, team2).teamsInfo()
    }

    fun battle() {
        do {
            for (i in 0..team1.list.lastIndex) {
                if (isBattleEnd) continue
                team1.list[i].attack(getLifeWarriors(team2))
                if (isBattleEnd) continue
                team2.list[i].attack(getLifeWarriors(team1))
            }
            isEnd()
            battleInfo()
            if (isBattleEnd) break
            TimeUnit.MILLISECONDS.sleep(600)
        } while (!isBattleEnd)

    }

    private fun isEnd() {
        isLifeTeam1 = isKilledAllWarriors(team2)
        isLifeTeam2 = isKilledAllWarriors(team1)

        if (isLifeTeam1) {

            BattleState.WinOneTeam("Teams One Win!")
            isBattleEnd = true
        } else if (isLifeTeam2) {
            isBattleEnd = true
            BattleState.WinTowTeam("Teams Two Win!")
        }
    }

    private fun getLifeWarriors(team: Team): Warrior? {
        team.list.forEach { warrior -> if (!warrior.isKilled) return warrior }
        isBattleEnd = true
        return null
    }

    private fun isKilledAllWarriors(team: Team): Boolean {
        team.list.forEach { warrior -> if (!warrior.isKilled) return false }
        return true
    }
}
