package com.toyibnurseha.mvvmpattern.setlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.toyibnurseha.mvvmpattern.repository.PokemonSetRepository
import com.toyibnurseha.mvvmpattern.viewmodel.SetListViewModel

class SetListFactory(private val setRepository: PokemonSetRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SetListViewModel::class.java))
            return SetListViewModel(setRepository) as T
        throw IllegalArgumentException()
    }

}