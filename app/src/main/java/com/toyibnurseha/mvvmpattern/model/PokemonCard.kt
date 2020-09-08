package com.toyibnurseha.mvvmpattern.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class PokemonCard(
    @PrimaryKey
    @NonNull
    var id: String,
    var name: String?,
    @SerializedName("imageUrl")
    var image: String?,
    var rarity: String?,
    var series: String?,
    var set: String?
) : Parcelable {
    data class PokemonCardResponse(
        var cards: MutableList<PokemonCard>
    )
}