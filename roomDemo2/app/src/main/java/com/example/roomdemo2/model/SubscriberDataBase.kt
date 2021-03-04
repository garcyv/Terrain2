package com.example.roomdemo2.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[Subscriber::class],version =1)
abstract class SubscriberDataBase:RoomDatabase() {
    abstract fun getsubscriberDAO: SubscriberDAO

    companion object{
        @Volatile

        private var INSTANCE: SubscriberDataBase? = null
        fun getDataBase(context: Context):SubscriberDataBase{

            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance}

            synchronized(this){
               val  instance= Room.databaseBuilder(
                    context.applicationContext,
                    SubscriberDataBase::class.java,
                    "subscriber_data_database"
                ).build()
                INSTANCE = instance
                return instance
            }


            }
        }


    }
}