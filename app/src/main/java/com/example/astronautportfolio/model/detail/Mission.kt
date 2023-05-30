package com.example.astronautportfolio.model.detail


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Mission(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("orbit")
    val orbit: Orbit,
    @SerializedName("type")
    val type: String
)