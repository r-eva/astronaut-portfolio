package com.example.astronautportfolio.data.remote.details


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class SpacecraftDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("serial_number")
    val serialNumber: String,
    @SerializedName("status")
    val status: SpacecraftStatusDto,
    @SerializedName("url")
    val url: String
)