package com.example.animalthread.data.api

import com.example.animalthread.data.models.AnimalResponse
import retrofit2.http.GET

interface AnimalApiService {
    @GET("v1/images/search")
    suspend fun getAnimal(): List<AnimalResponse>
}