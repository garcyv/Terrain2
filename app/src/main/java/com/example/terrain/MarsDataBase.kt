package com.example.terrain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.terrain.pojo.MarsTerrain

@Database(entities = [MarsTerrain::class], version = 1)
abstract class MarsDataBase: RoomDatabase() {

    abstract fun getTerrainDao(): MarsTerrainDao
    companion object {
      @Volatile
      private var INSTANCE: MarsDataBase? = null

      fun getDatabase(context: Context): MarsDataBase {
         val tempInstance = INSTANCE
          if (tempInstance != null) {
                    return tempInstance
          }
          synchronized(this) {
                val instance = Room.databaseBuilder(context,
                MarsDataBase::class.java,
                DATA_BASE_NAME)
                .build()
                INSTANCE = instance
                return instance
          }
      }

        private const val  DATA_BASE_NAME = "mars_db"
    }
}