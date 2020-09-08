package com.toyibnurseha.mvvmpattern.intrface

import com.toyibnurseha.mvvmpattern.model.PokemonSet

interface PokemonSetDataStore {
    suspend fun getSets(): MutableList<PokemonSet>?
    suspend fun addAll(sets: MutableList<PokemonSet>)
}