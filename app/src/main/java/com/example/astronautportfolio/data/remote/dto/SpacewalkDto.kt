package com.example.astronautportfolio.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class SpacewalkDto(
    val duration: String,
    val end: String,
    val id: Int,
    val location: String,
    val name: String,
    val start: String,
    val url: String
)