package com.example.astronautportfolio.data.remote.details


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class FlightDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("infographic")
    val infographic: String?,
    @SerializedName("mission")
    val mission: MissionDto,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: FlightStatusDto,
    @SerializedName("url")
    val url: String
)