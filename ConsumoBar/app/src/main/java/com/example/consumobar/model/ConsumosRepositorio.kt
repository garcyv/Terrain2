package com.example.consumobar.model

import androidx.lifecycle.LiveData

class ConsumosRepositorio(private val consumoDAO: ConsumosDAO) {

  val listAllConsumos: LiveData<List<Consumos>> = consumoDAO.getallconsumos()

  suspend fun creteConsumos(consumo: Consumos){
      consumoDAO.insertConsumo(consumo)
  }
  suspend fun  deleteConsumo(consumo: Consumos){
      consumoDAO.deleteConsumo(consumo)
  }

  fun  deleteAllConsumos(){
      consumoDAO.deleteAllConsumo()
  }
}