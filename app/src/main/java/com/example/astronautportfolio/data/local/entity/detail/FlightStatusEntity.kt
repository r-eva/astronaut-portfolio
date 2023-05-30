package com.example.astronautportfolio.data.local.entity.detail


import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class FlightStatusEntity(
    @SerializedName("abbrev")
    val abbrev: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)