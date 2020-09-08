package com.toyibnurseha.mvvmpattern.datastore

import com.toyibnurseha.mvvmpattern.intrface.PokemonCardDataStore
import com.toyibnurseha.mvvmpattern.database.dao.PokemonCardDao
import com.toyibnurseha.mvvmpattern.model.PokemonCard

class PokemonCardRoomDataStore(private val pokemonCardDao: PokemonCardDao) : PokemonCardDataStore {
    override suspend fun getPokemons(set: String): MutableList<PokemonCard>? {
        val response = pokemonCardDao.getAll(set)
        return if (response.isEmpty()) null else response
    }

    override suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?) {
        pokemons?.let { pokemonCardDao.insertAll(*it.toTypedArray()) }
    }
}