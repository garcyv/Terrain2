package com.example.dogs.model

import com.example.dogs.model.local.entities.DataDogImageEntity
import com.example.dogs.model.local.entities.DataDogRazaEntity
import com.example.dogs.model.remote.pojo.DataDogRaza
import com.example.dogs.model.remote.pojo.DataDogImage

fun fromInternetToBreedEntity(razaDog: DataDogRaza): List<DataDogRazaEntity> {
    return razaDog.message.map { DataDogRazaEntity(raza = it) }
}

fun fromInternetToImagesEntity(imageDog:DataDogImage, razaDog: String): List<DataDogImageEntity> {
    return imageDog.message.map{ DataDogImageEntity(imgURL = it, raza = razaDog) }
}