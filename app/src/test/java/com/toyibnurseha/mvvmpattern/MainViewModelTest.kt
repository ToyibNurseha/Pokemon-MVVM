package com.toyibnurseha.mvvmpattern

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.toyibnurseha.mvvmpattern.repository.PokemonSetRepository
import com.toyibnurseha.mvvmpattern.viewmodel.MainViewModel
import com.toyibnurseha.mvvmpattern.viewmodel.SetListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MainViewModelTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    var pokemonSetRepository: PokemonSetRepository? = null

    var mainViewModel: SetListViewModel? = null

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        mainViewModel = SetListViewModel(pokemonSetRepository!!)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

//    @Test
//    fun shouldLoadingWhenFirstInitialized() {
//        val state = mainViewModel!!.viewState.value!!
//        assertTrue(state.loading)
//        assertNull(state.error)
//        assertNull(state.data)
//    }

//    @Test
//    fun shouldStopLoadingAndGiveDataWhenSuccess() {
//        runBlocking {
//            `when`(pokemonSetRepository?.getSets()).thenReturn(mutableListOf())
//            mainViewModel?.getSets()
//            val state = mainViewModel!!.viewState.value!!
//            assertFalse(state.loading)
//            assertNull(state.error)
//            assertNotNull(state.data)
//        }
//    }

//    @Test
//    fun shouldThrowErrorWhenRepositoryIsThrowingError() {
//        runBlocking {
//            `when`(pokemonSetRepository?.getSets()).thenAnswer { throw Exception() }
//            mainViewModel?.getSets()
//            val state = mainViewModel!!.viewState.value!!
//            assertFalse(state.loading)
//            assertNotNull(state.error)
//            assertNull(state.data)
//        }
//    }
}