package com.example.dogs.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogs.databinding.ImageItemBinding
import com.example.dogs.model.local.entities.DataDogImageEntity

class ImagesAdapter: RecyclerView.Adapter<ImagesAdapter.ImageDogVH>() {
    var listImages = listOf<DataDogImageEntity>()
    val selectedImage = MutableLiveData<DataDogImageEntity>()

    fun update(list: List<DataDogImageEntity>) {
        listImages = list
        notifyDataSetChanged()
    }

    fun selectedImage(): LiveData<DataDogImageEntity> = selectedImage

    inner class ImageDogVH(private val binding: ImageItemBinding) :
            RecyclerView.ViewHolder(binding.root), View.OnLongClickListener {

        fun bind(image: DataDogImageEntity) {
            Glide.with(binding.root).load(image.imgURL).into(binding.ivDog)
            if (image.fav) {
                binding.ivFab.setColorFilter(Color.RED)
                binding.ivFab.visibility = View.VISIBLE
            } else {
                binding.ivFab.visibility = View.GONE
            }
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            selectedImage.value = listImages[adapterPosition]
            return true
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageDogVH {
        return ImageDogVH(ImageItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ImageDogVH, position: Int) {
        holder.bind(listImages[position])
    }

    override fun getItemCount() = listImages.size
}