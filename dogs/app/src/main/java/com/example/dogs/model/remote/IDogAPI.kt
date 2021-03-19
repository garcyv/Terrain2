package com.example.dogs.model.remote



import com.example.dogs.model.remote.pojo.DataDogImage
import com.example.dogs.model.remote.pojo.DataDogRaza
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IDogAPI {
    //revisar endpoint
    @GET("breeds/List")
    suspend fun fetchRazaList(): Response<DataDogRaza>

    @GET("breed/{raza}/images")
    suspend fun fetchImagesList(@Path("raza") raza: String): Response<DataDogImage>
}