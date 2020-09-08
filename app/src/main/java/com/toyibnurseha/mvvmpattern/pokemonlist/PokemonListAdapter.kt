package com.toyibnurseha.mvvmpattern.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.toyibnurseha.mvvmpattern.R
import com.toyibnurseha.mvvmpattern.model.PokemonCard
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    private val pokemonCards = mutableListOf<PokemonCard>()

    fun updateData(newPokemonCards: MutableList<PokemonCard>) {
        pokemonCards.clear()
        pokemonCards.addAll(newPokemonCards)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonListAdapter.ViewHolder, position: Int) {
        holder.bindItem(pokemonCards[position])
    }

    override fun getItemCount(): Int = pokemonCards.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bindItem(pokemonCard: PokemonCard) {
            with(itemView){
                Glide.with(containerView!!)
                    .load(pokemonCard.image)
                    .into(ivCardLogo)

                tvCardName.text = pokemonCard.name
                tvCardRarity.text = pokemonCard.rarity

                containerView?.setOnClickListener { view ->
                    val action = PokemonListFragmentDirections
                        .actionPokemonListFragmentToPokemonCardDetailFragment(
                            pokemonCard,
                            pokemonCard.name!!
                        )
                    view.findNavController().navigate(action)
                }
            }
        }
    }
}