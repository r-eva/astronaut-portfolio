package com.example.astronautportfolio.data.local.entity.detail


import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class LandingEntity(
    @SerializedName("destination")
    val destination: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("mission_end")
    val missionEnd: String,
    @SerializedName("spacecraft")
    val spacecraft: SpacecraftEntity,
    @SerializedName("url")
    val url: String
)