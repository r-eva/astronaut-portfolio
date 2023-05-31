package com.example.astronautportfolio.data.remote.details


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class LandingDto(
    @SerializedName("destination")
    val destination: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("spacecraft")
    val spacecraft: SpacecraftDto,
    @SerializedName("url")
    val url: String
)