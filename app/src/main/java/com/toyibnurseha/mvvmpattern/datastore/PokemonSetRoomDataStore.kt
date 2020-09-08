package com.toyibnurseha.mvvmpattern.datastore

import com.toyibnurseha.mvvmpattern.intrface.PokemonSetDataStore
import com.toyibnurseha.mvvmpattern.database.dao.PokemonSetDao
import com.toyibnurseha.mvvmpattern.model.PokemonSet

class PokemonSetRoomDataStore(private val pokemonSetDao: PokemonSetDao) : PokemonSetDataStore {
    override suspend fun getSets(): MutableList<PokemonSet>? {
        val response = pokemonSetDao.getAll()
        return if (response.isEmpty()) null else response
    }

    override suspend fun addAll(sets: MutableList<PokemonSet>) {
        sets.let { pokemonSetDao.insertAll() }
    }
}