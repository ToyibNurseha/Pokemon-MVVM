package com.toyibnurseha.mvvmpattern.pokemondetail

import com.toyibnurseha.mvvmpattern.model.PokemonCard
import com.toyibnurseha.mvvmpattern.model.PokemonSet

data class PokemonCardDetailViewState (
    var error: Exception? = null,
    var data: PokemonCard? = null
)