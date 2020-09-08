package com.toyibnurseha.mvvmpattern.setlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.toyibnurseha.mvvmpattern.R
import com.toyibnurseha.mvvmpattern.model.PokemonSet
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_main.view.*

class SetListAdapter : RecyclerView.Adapter<SetListAdapter.ViewHolder>() {

    private val pokemonSets = mutableListOf<PokemonSet>()

    fun updateData(newPokemonSets: MutableList<PokemonSet>) {
        pokemonSets.clear()
        pokemonSets.addAll(newPokemonSets)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

       val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(pokemonSets[position])
    }

    override fun getItemCount(): Int = pokemonSets.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bindItem(item: PokemonSet) {
            with(itemView) {
                Glide.with(containerView!!).load(item.logo).into(ivSetLogo)

                tvSetName.text = item.name
                containerView?.setOnClickListener { view ->
                    val action =
                        SetListFragmentDirections.actionSetListFragmentToPokemonListFragment(item.name)
                    view.findNavController().navigate(action)
                }
            }
        }
    }

}