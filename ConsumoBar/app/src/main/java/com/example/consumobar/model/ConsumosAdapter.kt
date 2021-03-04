package com.example.consumobar.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.consumobar.databinding.ConsumosItemBinding

class ConsumosAdapter:RecyclerView.Adapter<ConsumosAdapter.ConsumosViewHolder> (){
   private var mListConsumos = listOf<Consumos>()

    fun update(listConsumos:List<Consumos>){
        mListConsumos = listConsumos
        notifyDataSetChanged()
    }

    class ConsumosViewHolder(private val binding: ConsumosItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(consumo: Consumos){
 /*           binding.tvId.text = task.id.toString()
            binding.tvTitle .text = task.title
            binding.tcDescrip.text = task.taskDescription
            binding.checkBox.isChecked = task.state*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsumosViewHolder {
        return ConsumosViewHolder(ConsumosItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ConsumosViewHolder, position: Int) {
        val consumo = mListConsumos[position]
        holder.bind(consumo)
    }

    override fun getItemCount(): Int = mListConsumos.size
}