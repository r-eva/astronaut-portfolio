package com.example.astronautportfolio.data.remote.details


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class SpacewalkDto(
    @SerializedName("duration")
    val duration: String,
    @SerializedName("end")
    val end: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("url")
    val url: String
)