package com.toyibnurseha.mvvmpattern.datastore

import com.toyibnurseha.mvvmpattern.intrface.PokemonCardDataStore
import com.toyibnurseha.mvvmpattern.model.PokemonCard
import com.toyibnurseha.mvvmpattern.webservices.PokemonTcgService

class PokemonCardRemoteDataStore(private val pokemonTcgService: PokemonTcgService) : PokemonCardDataStore {
    override suspend fun getPokemons(set: String): MutableList<PokemonCard>? {
        val response = pokemonTcgService.getCards(set)
        if (response.isSuccessful) return response.body()?.cards

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?) {
    }
}