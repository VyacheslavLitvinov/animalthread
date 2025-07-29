package com.example.animalthread.di

import com.example.animalthread.BuildConfig
import com.example.animalthread.data.api.AnimalApiService
import com.example.animalthread.data.repository.AnimalRepositoryImpl
import com.example.animalthread.domain.AnimalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiKey(): String {
        return BuildConfig.DOG_API_KEY
    }

    @Provides
    @Singleton
    fun provideRetrofit(apiKey: String): Retrofit{
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                .addHeader(HEADER_API_KEY, apiKey)
                .build()
            chain.proceed(request)
        }
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.thedogapi.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): AnimalApiService {
        return retrofit.create(AnimalApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAnimalRepository(api: AnimalApiService): AnimalRepository {
        return AnimalRepositoryImpl(api)
    }

    private const val HEADER_API_KEY = "x-api-key"

}