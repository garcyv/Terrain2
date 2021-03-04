package com.example.terrain

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
       private const  val URL_BASE = "https://android-kotlin-fun-mars-server.appspot.com/"

        fun retrofitInstance():MarsInterface{
            val retrofit = Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(MarsInterface::class.java)
        }
    }
}