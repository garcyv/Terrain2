package com.example.dogs.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitDogClient {
    companion object {
        private const  val URL_BASE = "https://dog.ceo/api/"

        fun retrofitInstance():IDogAPI{
            val retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(IDogAPI::class.java)
        }
    }
}