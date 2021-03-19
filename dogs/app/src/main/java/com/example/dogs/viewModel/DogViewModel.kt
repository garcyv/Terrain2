package com.example.dogs.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.dogs.model.DogsRepository
import com.example.dogs.model.local.DogsDataBase
import com.example.dogs.model.local.entities.DataDogImageEntity
import com.example.dogs.model.local.entities.DataDogRazaEntity
import kotlinx.coroutines.launch

class DogViewModel(application: Application): AndroidViewModel(application) {
    private val repository : DogsRepository

    init {
        val db = DogsDataBase.getDatabase(application)
        val razaDao = db.razaDao()
        val imagesDao = db.imagesDao()
        repository = DogsRepository(imagesDao ,razaDao)

        viewModelScope.launch {
            repository.fetchRaza()
        }
    }

    //Todas las razas de perro desde la DataBase
    fun getBreedList(): LiveData<List<DataDogRazaEntity>> = repository.razaListLivedata

    // Para las images
    private var razaSeleccionada : String = ""

    fun getImagesByBreedFromInternet(raza: String) = viewModelScope.launch {
        razaSeleccionada = raza
        repository.fetchDogImages(raza)
    }

    fun getImages(): LiveData<List<DataDogImageEntity>> = repository.getAllImagesByraza(razaSeleccionada)


    fun updateFav(doggiesImage: DataDogImageEntity) = viewModelScope.launch {
        repository.updateFavImages(doggiesImage)
    }
}