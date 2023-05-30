package com.example.astronautportfolio.data.remote.details


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class OrbitDto(
    @SerializedName("abbrev")
    val abbrev: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)