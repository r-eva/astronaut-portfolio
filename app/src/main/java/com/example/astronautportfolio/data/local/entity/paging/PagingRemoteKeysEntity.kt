package com.example.astronautportfolio.data.local.entity.paging

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paging_remote_keys")
data class PagingRemoteKeysEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
