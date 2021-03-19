package com.example.dogs.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dogs.model.local.entities.DataDogRazaEntity

@Dao
interface IDogRazaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDataDogRazaList(listRaza: List<DataDogRazaEntity>)

    @Query("SELECT * FROM raza_table ORDER BY raza ASC")
    fun getAllDataDogRazaList(): LiveData<List<DataDogRazaEntity>>

}