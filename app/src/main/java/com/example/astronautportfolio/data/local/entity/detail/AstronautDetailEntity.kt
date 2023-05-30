package com.example.astronautportfolio.data.local.entity.detail


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "astronaut_detail_selected")
data class AstronautDetailEntity(
    @SerializedName("flights")
    val flights: List<FlightEntity>?,
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("landings")
    val landings: List<LandingEntity>?,
    @SerializedName("spacewalks")
    val spacewalks: List<SpacewalkEntity>?
)