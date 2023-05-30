package com.example.astronautportfolio.data.remote.details


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class SpacecraftStatusDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)