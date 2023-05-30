package com.example.astronautportfolio.data.local.entity.detail


import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class SpacecraftStatusEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)