package com.toyibnurseha.mvvmpattern.datastore

import com.toyibnurseha.mvvmpattern.intrface.PokemonSetDataStore
import com.toyibnurseha.mvvmpattern.model.PokemonSet
import com.toyibnurseha.mvvmpattern.webservices.PokemonTcgService
import java.lang.Exception

class PokemonSetRemoteDataStore(private val pokemonTcgService: PokemonTcgService) : PokemonSetDataStore {
    override suspend fun getSets(): MutableList<PokemonSet>? {
        val response = pokemonTcgService.getSets()
        if (response.isSuccessful) return response.body()?.sets

        throw Exception("Something Error while fetching data ${response.code()}")
    }

    override suspend fun addAll(sets: MutableList<PokemonSet>) {
        TODO("Not yet implemented")
    }
}