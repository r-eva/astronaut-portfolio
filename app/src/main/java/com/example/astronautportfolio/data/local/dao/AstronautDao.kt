package com.example.astronautportfolio.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.astronautportfolio.data.local.entity.detail.AstronautDetailEntity
import com.example.astronautportfolio.data.local.entity.overview.ResultEntity

@Dao
interface AstronautDao {
    @Upsert
    suspend fun upsertAll(astronautsList: List<ResultEntity>)

    @Query("SELECT * FROM astronaut")
    fun pagingSource(): PagingSource<Int, ResultEntity>

    @Query("DELETE FROM astronaut")
    suspend fun clearAll()

}