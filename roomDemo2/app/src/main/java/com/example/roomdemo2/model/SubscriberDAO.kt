package com.example.roomdemo2.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {
    @Insert
    suspend fun insertSubscriber(subscriber:Subscriber):Long

    @Update
    suspend fun updateSubscriber2(subscriber:Subscriber):Long

    @Delete
    suspend fun deleteSubscriber(subscriber:Subscriber)

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber_data_table")
    suspend fun getAllSubscriber(): LiveData<List<Subscriber>>
}