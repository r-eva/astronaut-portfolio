package com.example.astronautportfolio.data.remote.dto

import kotlinx.serialization.Serializable
@Serializable
data class StatusDto(
    val id: Int,
    val name: String
)