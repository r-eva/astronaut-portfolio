package com.example.astronautportfolio.data.local.entity.overview

import androidx.room.Entity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Entity
data class TypeEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)