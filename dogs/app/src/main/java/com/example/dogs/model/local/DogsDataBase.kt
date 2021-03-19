package com.example.dogs.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dogs.model.local.dao.IDogImagesDao
import com.example.dogs.model.local.dao.IDogRazaDao
import com.example.dogs.model.local.entities.DataDogImageEntity
import com.example.dogs.model.local.entities.DataDogRazaEntity

@Database(entities = [DataDogRazaEntity::class, DataDogImageEntity::class], version=1, exportSchema=false)
abstract class DogsDataBase: RoomDatabase() {

    abstract fun razaDao():IDogRazaDao
    abstract fun imagesDao(): IDogImagesDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DogsDataBase? = null

        fun getDatabase(context: Context): DogsDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        DogsDataBase::class.java,
                        "dogs_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}