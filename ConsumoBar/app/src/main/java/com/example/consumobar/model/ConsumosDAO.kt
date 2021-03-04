package com.example.consumobar.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ConsumosDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConsumo(consumo: Consumos)

    @Query("SELECT * FROM consumos_table")
    fun getallconsumos():LiveData<List<Consumos>>

    @Query("DELETE FROM consumos_table")
    fun deleteAllConsumo()

    @Delete
    suspend fun deleteConsumo(consumo: Consumos)

}