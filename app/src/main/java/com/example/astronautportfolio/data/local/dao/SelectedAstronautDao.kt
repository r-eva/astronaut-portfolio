package com.example.astronautportfolio.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.astronautportfolio.data.local.entity.detail.AstronautDetailEntity
import com.example.astronautportfolio.data.local.entity.paging.PagingRemoteKeysEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SelectedAstronautDao {
    @Query("SELECT * FROM astronaut_detail_selected WHERE id = :astronautId")
    suspend fun getAstronautDetailById(astronautId: Int): List<AstronautDetailEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAstronautDetail(astronaut: AstronautDetailEntity)

    @Query("DELETE FROM astronaut_detail_selected WHERE id = :astronautId")
    suspend fun deleteAstronautDetail(astronautId: Int)
}