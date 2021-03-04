package com.example.terrain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.terrain.pojo.MarsTerrain
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsRepository {

    private val services = RetrofitClient.retrofitInstance()
    val liveDataMarsTerrain = MutableLiveData<List<MarsTerrain>>()

    //vieja confiable
    fun fetchMarsTerrainEnqueue(): LiveData<List<MarsTerrain>> {
        services.fetchMarsTerrainEnqueue().enqueue(object : Callback<List<MarsTerrain>> {
            override fun onResponse(
                    call: Call<List<MarsTerrain>>,
                    response: Response<List<MarsTerrain>>
            ) {
                when (response.code()) {
                   in 200..209 -> {
                       Log.d("OK","llegaron datos")
                       liveDataMarsTerrain.value = response.body()}
                   in 300..399 -> Log.d("ERROR",response.errorBody().toString())
                   else -> Log.d("ERROR","error del server ${response.code()}")
                }

            }

            override fun onFailure(call: Call<List<MarsTerrain>>, t: Throwable) {
               Log.e("ERROR",t.message.toString())
            }
        })

        return liveDataMarsTerrain
    }

    //Funcion q utiliza coroutines
    suspend fun getTerrainWithCoroutines(){
        Log.d("REPOSITORY","USO CORoutines")
        try {
            val response = RetrofitClient.retrofitInstance().fetchMarsTerrainCoroutines()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    liveDataMarsTerrain.value = it
                }
                false -> Log.d("ERROR", " ${response.code()}: ${response.errorBody()}")
            }
        } catch (t:Throwable){
            Log.d("ERROR COR",t.message.toString())
        }
    }

}