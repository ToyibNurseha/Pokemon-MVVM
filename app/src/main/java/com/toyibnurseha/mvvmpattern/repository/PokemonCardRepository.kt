package com.toyibnurseha.mvvmpattern.repository

import com.toyibnurseha.mvvmpattern.intrface.PokemonCardDataStore
import com.toyibnurseha.mvvmpattern.model.PokemonCard

class PokemonCardRepository private constructor() : BaseRepository<PokemonCardDataStore>() {

    suspend fun getPokemons(set: String): MutableList<PokemonCard>? {
        val cache = localDataStore?.getPokemons(set)
        if (cache!= null) return cache
        return remoteDataStore?.getPokemons(set)
    }

    companion object {
        val instance by lazy { PokemonCardRepository() }
    }
}