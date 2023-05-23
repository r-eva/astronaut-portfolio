package com.example.astronautportfolio.data.local.entity

import androidx.room.Entity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TypeEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)