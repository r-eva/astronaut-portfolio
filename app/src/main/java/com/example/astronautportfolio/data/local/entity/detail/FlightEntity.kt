package com.example.astronautportfolio.data.local.entity.detail


import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class FlightEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("infographic")
    val infographic: String?,
    @SerializedName("mission")
    val mission: MissionEntity,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: FlightStatusEntity,
    @SerializedName("url")
    val url: String
)