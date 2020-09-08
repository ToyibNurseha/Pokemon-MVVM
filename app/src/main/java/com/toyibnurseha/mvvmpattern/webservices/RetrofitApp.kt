package com.toyibnurseha.mvvmpattern.webservices

import com.toyibnurseha.mvvmpattern.model.PokemonCard
import com.toyibnurseha.mvvmpattern.model.PokemonSet
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object RetrofitApp {
    private const val BASE_URL = "https://api.pokemontcg.io/v1/"

    private val client = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val POKEMON_TCG_SERVICE: PokemonTcgService = client.create(PokemonTcgService::class.java)
}

