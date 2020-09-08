package com.toyibnurseha.mvvmpattern

import android.app.Application
import com.toyibnurseha.mvvmpattern.database.AppDatabase
import com.toyibnurseha.mvvmpattern.datastore.PokemonCardRemoteDataStore
import com.toyibnurseha.mvvmpattern.datastore.PokemonCardRoomDataStore
import com.toyibnurseha.mvvmpattern.datastore.PokemonSetRemoteDataStore
import com.toyibnurseha.mvvmpattern.datastore.PokemonSetRoomDataStore
import com.toyibnurseha.mvvmpattern.repository.PokemonCardRepository
import com.toyibnurseha.mvvmpattern.repository.PokemonSetRepository
import com.toyibnurseha.mvvmpattern.webservices.RetrofitApp

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val pokemonTcgService = RetrofitApp.POKEMON_TCG_SERVICE
        val appDatabase = AppDatabase.getInstance(this)
        PokemonSetRepository.instance.apply {
            init(
                PokemonSetRoomDataStore(appDatabase.pokemonSetDao()),
                PokemonSetRemoteDataStore(pokemonTcgService)
            )
        }

        PokemonCardRepository.instance.apply {
            init(
                PokemonCardRoomDataStore(appDatabase.pokemonCardDao()),
                PokemonCardRemoteDataStore(pokemonTcgService)
            )
        }
    }
}