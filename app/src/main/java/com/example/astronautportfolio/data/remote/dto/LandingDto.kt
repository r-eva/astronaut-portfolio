package com.example.astronautportfolio.data.remote.dto


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
@Serializable
data class LandingDto(
    val destination: String,
    val id: Int,
    val url: String
)