package com.example.astronautportfolio.data.local.entity.detail


import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class OrbitEntity(
    @SerializedName("abbrev")
    val abbrev: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)