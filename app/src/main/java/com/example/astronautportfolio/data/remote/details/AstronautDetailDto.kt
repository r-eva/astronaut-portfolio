package com.example.astronautportfolio.data.remote.details


import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class AstronautDetailDto(
    @SerializedName("flights")
    val flights: List<FlightDto>?,
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("landings")
    val landings: List<LandingDto>,
    @SerializedName("spacewalks")
    val spacewalks: List<SpacewalkDto>
)