package com.example.astronautportfolio.data.local.entity.detail


import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class SpacewalkEntity(
    @SerializedName("duration")
    val duration: String,
    @SerializedName("end")
    val end: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("url")
    val url: String
)