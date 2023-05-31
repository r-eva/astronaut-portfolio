package com.example.astronautportfolio.model.detail


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Flight(
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("infographic")
    val infographic: String?,
    @SerializedName("mission")
    val mission: Mission,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: FlightStatus,
    @SerializedName("url")
    val url: String
)