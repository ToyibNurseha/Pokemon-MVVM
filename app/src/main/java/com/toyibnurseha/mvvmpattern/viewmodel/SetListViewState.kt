package com.toyibnurseha.mvvmpattern.viewmodel

import com.toyibnurseha.mvvmpattern.model.PokemonSet

data class SetListViewState (
    var loading: Boolean = false,
    var error: Exception? = null,
    var data: MutableList<PokemonSet>? = null
)