package com.example.astronautportfolio.data.local.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity (tableName = "astronauts_api_result")
data class AstronautsListEntity(
    @SerialName("count")
    @PrimaryKey
    val count: Int,
    @SerialName("next")
    val next: String?,
    @SerialName("previous")
    val previous: String?,
    @SerialName("results")
    val results: List<ResultEntity>
)