package com.example.consumobar

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.consumobar.model.Consumos
import com.example.consumobar.model.ConsumosDB
import com.example.consumobar.model.ConsumosRepositorio
import kotlinx.coroutines.launch

class ConsumosViewModel (application: Application): AndroidViewModel(application) {
    private val repositorio: ConsumosRepositorio
    val allConsumos: LiveData<List<Consumos>>

    init {
        val consumoDAO = ConsumosDB.getDataBase(application).getConsumosDAO()
        repositorio = ConsumosRepositorio(consumoDAO)
        allConsumos = repositorio.listAllConsumos
    }

    fun InsertConsumo(consumo:Consumos) = viewModelScope.launch {
      repositorio.creteConsumos(consumo)
  }

    fun deleteAllConsumos() = viewModelScope.launch {
        repositorio.deleteAllConsumos()
    }
}