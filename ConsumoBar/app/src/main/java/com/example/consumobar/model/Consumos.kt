package com.example.consumobar.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "consumos_table")
data class Consumos (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val precio: Int,
    val cantidad: Int,
    val total: Int
)