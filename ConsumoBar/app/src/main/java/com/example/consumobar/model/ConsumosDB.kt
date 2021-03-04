package com.example.consumobar.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[Consumos::class], version = 1 )
abstract class ConsumosDB: RoomDatabase() {

    abstract fun getConsumosDAO(): ConsumosDAO

    companion object{
        @Volatile
        private var INSTANCE : ConsumosDB? = null

        fun getDataBase(context: Context): ConsumosDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ConsumosDB::class.java,
                     "consumosDB")
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}