package com.example.dogs.model.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "imgraza_table")
data class DataDogImageEntity(
        @PrimaryKey
        val imgURL:String,
        val raza:String,
        var fav: Boolean = false
        )
