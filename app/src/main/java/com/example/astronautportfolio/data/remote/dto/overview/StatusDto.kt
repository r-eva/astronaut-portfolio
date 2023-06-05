package com.example.astronautportfolio.data.remote.dto.overview

import kotlinx.serialization.Serializable
@Serializable
data class StatusDto(
    val id: Int,
    val name: String
)