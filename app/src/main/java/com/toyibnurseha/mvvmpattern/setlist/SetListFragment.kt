package com.toyibnurseha.mvvmpattern.setlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.toyibnurseha.mvvmpattern.R
import com.toyibnurseha.mvvmpattern.model.PokemonSet
import com.toyibnurseha.mvvmpattern.repository.PokemonSetRepository
import com.toyibnurseha.mvvmpattern.viewmodel.SetListViewModel
import com.toyibnurseha.mvvmpattern.viewmodel.SetListViewState
import kotlinx.android.synthetic.main.fragment_set_list.*

class SetListFragment : Fragment() {

    private lateinit var vm: SetListViewModel
    private lateinit var adapter: SetListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_set_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SetListAdapter()
        rvSet.adapter = adapter

        val factory = SetListFactory(PokemonSetRepository.instance)
        vm = ViewModelProviders.of(this, factory).get(SetListViewModel::class.java).apply {
            viewState.observe(viewLifecycleOwner, Observer(this@SetListFragment::handleState))
            srlSet.setOnRefreshListener { getSets() }
        }
    }

    private fun handleState(viewState: SetListViewState?) {
        viewState?.let {
            toggleLoading(it.loading)
            it.data?.let { data -> showData(data) }
            it.error?.let { error -> showError(error) }
        }
    }

    private fun showError(error: Exception) {
        tvSetError.text = error.message
        tvSetError.visibility = View.VISIBLE
        rvSet.visibility = View.GONE
    }

    private fun showData(data: MutableList<PokemonSet>) {
        adapter.updateData(data)
        tvSetError.visibility = View.GONE
        rvSet.visibility = View.VISIBLE
    }

    private fun toggleLoading(loading: Boolean) {
        srlSet.isRefreshing = loading
    }

}