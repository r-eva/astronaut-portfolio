package com.example.astronautportfolio.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.astronautportfolio.data.local.entity.detail.AstronautDetailEntity
import com.example.astronautportfolio.data.local.entity.paging.PagingRemoteKeysEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SelectedAstronautDao {
    @Query("SELECT * FROM astronaut_detail_selected WHERE id =:id")
    suspend fun getAstronautDetailById(id: Int): AstronautDetailEntity

    @Query("SELECT * FROM astronaut_detail_selected")
    suspend fun getAllDetail(): List<AstronautDetailEntity>


    @Upsert
    suspend fun addAstronautDetail(astronaut: AstronautDetailEntity)

    @Query("DELETE FROM astronaut_detail_selected WHERE id = :astronautId")
    suspend fun deleteAstronautDetail(astronautId: Int)
}