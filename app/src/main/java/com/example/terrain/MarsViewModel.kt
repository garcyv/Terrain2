package com.example.terrain

import android.app.Application
import androidx.lifecycle.*
import com.example.terrain.pojo.MarsTerrain
import kotlinx.coroutines.launch

class MarsViewModel(application: Application): AndroidViewModel(application) {

    private val repository: MarsRepository
    val allData: LiveData<List<MarsTerrain>>
    val selectedMarsTerrain: MutableLiveData<MarsTerrain> = MutableLiveData()

    init {
        val marsTerrain = MarsDataBase.getDatabase(application).getTerrainDao()
        repository = MarsRepository(marsTerrain)
        viewModelScope.launch{
        repository.getTerrainWithCoroutines()
        }
        allData =repository.listAllData
    }


    fun getFetchTerrains() : LiveData<List<MarsTerrain>> {
        return repository.fetchMarsTerrainEnqueue()
    }

    fun getFetchTerrainsWithCoroutines(): LiveData<List<MarsTerrain>> {
        return repository.liveDataMarsTerrain
    }

    fun selected(marsTerrain: MarsTerrain?) {

        selectedMarsTerrain.value = marsTerrain
    }
}