package com.example.astronautportfolio.data.remote.overview.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatusDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)