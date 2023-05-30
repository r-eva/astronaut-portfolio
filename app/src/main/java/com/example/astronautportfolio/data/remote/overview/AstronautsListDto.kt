package com.example.astronautportfolio.data.remote.overview
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class AstronautsListDto(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String?,
    @SerialName("previous")
    val previous: String?,
    @SerialName("results")
    val results: List<ResultDto>
)