package com.example.roomdemo.db

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscriber_data_table")
data class Subscriber(
    @PrimaryKey(autogenerate=true)
    @ColumnInfo(name="subscriber_id")
    val id:Int,
    @ColumnInfo(name="subscriber_name")
    val name : String,
    @ColumnInfo(name="subscriber_email")
    val email : String
)