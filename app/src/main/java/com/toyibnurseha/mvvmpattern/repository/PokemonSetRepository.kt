package com.toyibnurseha.mvvmpattern.repository

import com.toyibnurseha.mvvmpattern.intrface.PokemonSetDataStore
import com.toyibnurseha.mvvmpattern.model.PokemonSet

class PokemonSetRepository private constructor() : BaseRepository<PokemonSetDataStore>() {

    suspend fun getSets(): MutableList<PokemonSet>? {
        val cache = localDataStore?.getSets()
        if (cache != null) return cache
        val response = remoteDataStore?.getSets()
        if (response != null) {
            localDataStore?.addAll(response)
        }
        return response
    }

    companion object {
        val instance by lazy { PokemonSetRepository() }
    }
}