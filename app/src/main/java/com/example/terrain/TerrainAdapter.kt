package com.example.terrain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.terrain.databinding.MarsItemListBinding
import com.example.terrain.pojo.MarsTerrain

class TerrainAdapter: RecyclerView.Adapter<TerrainAdapter.MarsVH>() {

    private var listMarsItem = listOf<MarsTerrain>()

    fun update(list: List<MarsTerrain>){
        listMarsItem = list
        notifyDataSetChanged()
    }

 inner class MarsVH(private val binding: MarsItemListBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(marsTerrain: MarsTerrain){
                   Glide.with(binding.ivTerrain)
                           .load(marsTerrain.imgSrc)
                           .centerCrop()
                           .into(binding.ivTerrain)
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsVH {
       return MarsVH(MarsItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsVH, position: Int) {
        val marsTerrain = listMarsItem[position]
        holder.bind(marsTerrain)
    }

    override fun getItemCount(): Int= listMarsItem.size
}