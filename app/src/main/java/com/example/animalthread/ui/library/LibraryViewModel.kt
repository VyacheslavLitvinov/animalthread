package com.example.animalthread.ui.library

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animalthread.data.AnimalResponse
import com.example.animalthread.data.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LibraryViewModel: ViewModel() {

    val catImage = MutableLiveData<String?>()

    fun getRandomImage(){
        Retrofit.api.getAnimal().enqueue(object : Callback<List<AnimalResponse>>{
            override fun onResponse(
                call: Call<List<AnimalResponse>>,
                responce: Response<List<AnimalResponse>>
            ) {
                if(responce.isSuccessful && !responce.body().isNullOrEmpty()){
                    catImage.value = responce.body()!![0].url
                }
            }

            override fun onFailure(call: Call<List<AnimalResponse>>, t: Throwable) {
                catImage.value = null
            }
        })
    }

}