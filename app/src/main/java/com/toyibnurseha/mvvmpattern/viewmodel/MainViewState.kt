package com.toyibnurseha.mvvmpattern.viewmodel

import com.toyibnurseha.mvvmpattern.model.PokemonSet

data class MainViewState (
    var loading: Boolean = false,
    var error: Exception? = null,
    var data: MutableList<PokemonSet>? = null
)