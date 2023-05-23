package com.example.astronautportfolio.model.overview
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AstronautsList(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String?,
    @SerialName("previous")
    val previous: String?,
    @SerialName("results")
    val results: List<Result>
)