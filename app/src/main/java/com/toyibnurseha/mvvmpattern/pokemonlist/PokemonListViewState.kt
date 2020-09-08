package com.toyibnurseha.mvvmpattern.pokemonlist

import com.toyibnurseha.mvvmpattern.model.PokemonCard

data class PokemonListViewState (
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<PokemonCard>? = null
)