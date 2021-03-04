package com.example.terrain

import com.example.terrain.pojo.MarsTerrain
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MarsInterface {
    //Vieja confiable
    @GET("realestate")
    fun fetchMarsTerrainEnqueue():Call<List<MarsTerrain>>

    //recomendada
    @GET("realestate")
    suspend fun fetchMarsTerrainCoroutines(): Response<List<MarsTerrain>>

}