package com.example.astronautportfolio.model.overview

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Type(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)