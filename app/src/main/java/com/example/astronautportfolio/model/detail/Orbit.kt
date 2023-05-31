package com.example.astronautportfolio.model.detail


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Orbit(
    @SerializedName("abbrev")
    val abbrev: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)