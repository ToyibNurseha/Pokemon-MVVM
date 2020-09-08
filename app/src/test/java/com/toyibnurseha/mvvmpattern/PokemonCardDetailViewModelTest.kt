package com.toyibnurseha.mvvmpattern

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.toyibnurseha.mvvmpattern.model.PokemonCard
import com.toyibnurseha.mvvmpattern.pokemondetail.PokemonCardDetailViewModel
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokemonCardDetailViewModelTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    var pokemonCardDetailViewMode: PokemonCardDetailViewModel? = null

    @Before
    fun init(){
        pokemonCardDetailViewMode = PokemonCardDetailViewModel()
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun shouldNullWhenFirstInitialized() {
        val state = pokemonCardDetailViewMode!!.viewState.value!!
        assertNull(state.data)
    }

    @Test
    fun shouldNotNullAfterSetData() {
        pokemonCardDetailViewMode?.setData(PokemonCard("", "", "", "", "", ""))
        val state = pokemonCardDetailViewMode!!.viewState.value!!
        assertNotNull(state.data)
    }
}