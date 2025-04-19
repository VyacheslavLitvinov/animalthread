package com.example.animalthread.data

import retrofit2.Call
import retrofit2.http.GET

interface AnimalApiService {

    @GET("v1/images/search")
    fun getAnimal(): Call<List<AnimalResponse>>

}