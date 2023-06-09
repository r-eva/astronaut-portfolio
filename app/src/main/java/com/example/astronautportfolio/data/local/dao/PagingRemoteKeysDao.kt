package com.example.astronautportfolio.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.astronautportfolio.data.local.entity.paging.PagingRemoteKeysEntity

@Dao
interface PagingRemoteKeysDao {
    @Query("SELECT * FROM paging_remote_keys WHERE id =:id")
    suspend fun getRemoteKeys(id: Int): PagingRemoteKeysEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<PagingRemoteKeysEntity>)

    @Query("DELETE FROM paging_remote_keys")
    suspend fun deleteAllRemoteKeys()

}