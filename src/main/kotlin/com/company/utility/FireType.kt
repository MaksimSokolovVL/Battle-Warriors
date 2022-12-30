package com.company.utility

sealed class FireType{
    object OneShot: FireType(){}
    data class Burst(val countFire: Int=3): FireType()
}


