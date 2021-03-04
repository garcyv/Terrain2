package com.example.terrain.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "terrain_table")
data class MarsTerrain(val price: Long,
                   @PrimaryKey
                   val id: String,
                   val type: String,
                   @SerializedName("img_src")
                   val imgSrc: String)

