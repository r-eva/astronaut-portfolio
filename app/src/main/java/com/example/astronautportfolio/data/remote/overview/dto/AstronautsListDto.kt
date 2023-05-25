package com.example.astronautportfolio.data.remote.overview.dto
import androidx.room.Embedded
import com.example.astronautportfolio.data.remote.overview.dto.ResultDto
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
    @Embedded
    val results: List<ResultDto>
)