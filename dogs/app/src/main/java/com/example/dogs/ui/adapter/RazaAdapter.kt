package com.example.dogs.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.databinding.RazaItemBinding
import com.example.dogs.model.local.entities.DataDogRazaEntity

class RazaAdapter: RecyclerView.Adapter<RazaAdapter.RazaDogViewHolder>() {

    private var listRaza = listOf<DataDogRazaEntity>()
    private val razaSeleccionada = MutableLiveData<DataDogRazaEntity>()
    fun update(list: List<DataDogRazaEntity>) {
        listRaza = list
        notifyDataSetChanged()
    }

    fun razaSeleccionada(): LiveData<DataDogRazaEntity> = razaSeleccionada

    inner  class RazaDogViewHolder(private val binding: RazaItemBinding) :
            RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(raza: DataDogRazaEntity) {
            binding.tvraza.text = raza.raza
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            razaSeleccionada.value = listRaza[adapterPosition]
        }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RazaDogViewHolder {
        return RazaDogViewHolder(RazaItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RazaDogViewHolder, position: Int) {
        holder.bind(listRaza[position])
    }

    override fun getItemCount() = listRaza.size
}