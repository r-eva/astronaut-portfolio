package com.example.astronautportfolio.model.detail


import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class AstronautDetail(
    @SerializedName("flights")
    val flights: List<Flight>?,
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("landings")
    val landings: List<Landing>,
    @SerializedName("spacewalks")
    val spacewalks: List<Spacewalk>
)