package com.example.dogs.model

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.dogs.model.local.dao.IDogRazaDao
import com.example.dogs.model.local.dao.IDogImagesDao
import com.example.dogs.model.local.entities.DataDogImageEntity
import com.example.dogs.model.remote.RetrofitDogClient



class DogsRepository(private val imagesDao: IDogImagesDao, private val dataDogDao: IDogRazaDao) {

    private val services = RetrofitDogClient.retrofitInstance()
    val razaListLivedata = dataDogDao.getAllDataDogRazaList()

    //Funcion q utiliza corrutinas
    suspend fun fetchRaza(){
        val service = kotlin.runCatching { services.fetchRazaList() }
        service.onSuccess {
            when (it.code()) {
                200 -> it.body()?.let {
                    dataDogDao.insertAllDataDogRazaList(fromInternetToBreedEntity(it))
                }
                else -> Log.d("REPO", "${it.code()} - ${it.errorBody()}")
            }
        }
    }

    //Recibe la raza y realiza la solicitud guardando el elemento en la Base de datos.
    suspend fun fetchDogImages(breed: String) {
        val service = kotlin.runCatching { services.fetchImagesList(breed) }
        service.onSuccess {
            when (it.code()) {
                200 -> it.body()?.let {
                    imagesDao.insertAllImagesList(fromInternetToImagesEntity(it, breed))
                }
                else -> Log.d("REPO-IMG", "${it.code()} - ${it.errorBody()}")
            }
        }
        service.onFailure {
            Log.e("REPO", "${it.message}")
        }
    }
    // Retorna las imagenes por raza desde la base de datos.
    fun getAllImagesByraza(raza: String): LiveData<List<DataDogImageEntity>> {
        return imagesDao.getAllDogsImages(raza)
    }

    suspend fun updateFavImages(dogImage: DataDogImageEntity) {
        imagesDao.updateFavImages(dogImage)
    }

}

