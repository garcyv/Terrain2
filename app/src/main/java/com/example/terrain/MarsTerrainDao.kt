package com.example.terrain

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.terrain.pojo.MarsTerrain


@Dao
interface MarsTerrainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTerrains(mTerrainsList: List<MarsTerrain>)

    @Query("SELECT * FROM terrain_table")
    fun getAllTerrainsFromDB(): LiveData<List<MarsTerrain>>
}
