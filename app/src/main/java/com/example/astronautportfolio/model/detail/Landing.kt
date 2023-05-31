package com.example.astronautportfolio.model.detail


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Landing(
    @SerializedName("destination")
    val destination: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("spacecraft")
    val spacecraft: Spacecraft,
    @SerializedName("url")
    val url: String
)