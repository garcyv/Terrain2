package com.example.roomdemo.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[Subscriber::class],version =1)
abstract class SubscriberDatabase:RoomDatabase() {
    abstract val subscriberDAO: SubscriberDAO

    companion object{
        @Volatile

        private var INSTANCE: SubscriberDatabase? = null

        fun getInstance(context: Context):SubscriberDatabase{
            synchonized(lock:this){
                var instance:SubscriberDataBase? = INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        SubscriberDatabase::class.java,
                        name:"subscriber_data_database"
                    ).build()
                }
                return instance
            }
        }

    }
}