package com.example.terrain

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.terrain.pojo.MarsTerrain
import kotlinx.coroutines.launch

class MarsViewModel: ViewModel() {

    private val repository: MarsRepository

    init {
        repository = MarsRepository()
        viewModelScope.launch{
        repository.getTerrainWithCoroutines()
        }
    }


    fun getFetchTerrains() : LiveData<List<MarsTerrain>> {
        return repository.fetchMarsTerrainEnqueue()
    }

    fun getFetchTerrainsWithCoroutines(): LiveData<List<MarsTerrain>> {
        return repository.liveDataMarsTerrain
    }
}