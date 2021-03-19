package com.example.dogs.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.dogs.model.local.entities.DataDogImageEntity

interface IDogImagesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllImagesList(listRaza: List<DataDogImageEntity>)

    @Update
    suspend fun updateFavImages(dogsImage: DataDogImageEntity)

    @Query("SELECT * FROM imgraza_table WHERE raza = :raza")
    fun getAllDogsImages(raza : String): LiveData<List<DataDogImageEntity>>

    // Funcion que trae todos los favoritos
    @Query("SELECT * FROM  imgraza_table WHERE fav = 1")
    fun getAllFavImages(): LiveData<List<DataDogImageEntity>>
}