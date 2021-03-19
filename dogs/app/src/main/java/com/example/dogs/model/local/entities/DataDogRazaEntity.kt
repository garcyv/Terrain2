package com.example.dogs.model.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "raza_table")
data class DataDogRazaEntity(
    @PrimaryKey val raza:String
)
