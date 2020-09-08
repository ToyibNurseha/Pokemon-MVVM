package com.toyibnurseha.mvvmpattern.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toyibnurseha.mvvmpattern.repository.PokemonSetRepository
import kotlinx.coroutines.launch
class SetListViewModel(private val pokemonSets: PokemonSetRepository) : ViewModel() {
    private val mViewState = MutableLiveData<SetListViewState>().apply {
        value = SetListViewState(loading = true)
    }

    val viewState: LiveData<SetListViewState>
        get() = mViewState

    init {
        getSets()
    }

    fun getSets() = viewModelScope.launch {
        try {
            val data = pokemonSets.getSets()
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        }catch (e: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = e, data = null)
        }
    }

}

