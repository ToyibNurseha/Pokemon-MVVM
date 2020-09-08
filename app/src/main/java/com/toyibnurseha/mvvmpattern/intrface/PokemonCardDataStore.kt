package com.toyibnurseha.mvvmpattern.intrface

import com.toyibnurseha.mvvmpattern.model.PokemonCard

interface PokemonCardDataStore {
    suspend fun getPokemons(set: String): MutableList<PokemonCard>?
    suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?)
}