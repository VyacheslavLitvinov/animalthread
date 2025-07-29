package com.example.animalthread.data.repository

import com.example.animalthread.data.api.AnimalApiService
import com.example.animalthread.domain.AnimalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimalRepositoryImpl(
    private val apiService: AnimalApiService
) : AnimalRepository {
    override suspend fun getRandomAnimalUrl(): String? = withContext(Dispatchers.IO) { ///сразу прописываю контекст корутины, чтобы не писать при каждом вызове функции
        return@withContext try {
            val list = apiService.getAnimal()
            list.firstOrNull()?.url
        } catch (e: Exception) {
            null
        }
    }
}