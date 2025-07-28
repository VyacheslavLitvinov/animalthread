package com.example.animalthread.domain

interface AnimalRepository {
    suspend fun getRandomAnimalUrl(): String?
}