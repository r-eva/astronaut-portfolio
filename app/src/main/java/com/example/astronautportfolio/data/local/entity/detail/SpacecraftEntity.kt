package com.example.astronautportfolio.data.local.entity.detail


import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class SpacecraftEntity(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("serial_number")
    val serialNumber: String,
    @SerializedName("status")
    val status: SpacecraftStatusEntity,
    @SerializedName("url")
    val url: String
)