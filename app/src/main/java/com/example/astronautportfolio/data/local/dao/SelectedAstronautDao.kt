package com.example.astronautportfolio.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.astronautportfolio.data.local.entity.detail.AstronautDetailEntity
import com.example.astronautportfolio.data.local.entity.paging.PagingRemoteKeysEntity

@Dao
interface SelectedAstronautDao {
    @Query("SELECT * FROM astronaut_detail_selected")
    suspend fun getAstronautDetailById(): AstronautDetailEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAstronautDetail(astronaut: AstronautDetailEntity)

    @Query("DELETE FROM astronaut_detail_selected")
    suspend fun deleteAllRemoteKeys()
}