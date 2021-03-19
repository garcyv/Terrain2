package com.example.dogs.model.remote.pojo

import com.google.gson.annotations.SerializedName

data class DataDogRaza(
        @SerializedName("message")
        val message : List<String>,
        @SerializedName("status")
        val status : String
)
