package com.example.animalthread.data.models

import com.google.gson.annotations.SerializedName

/**
 * "breeds":[{
 *     "weight":{"imperial":"7  -  10","metric":"3 - 5"},
 *     "id":"abys","name":"Abyssinian",
 *     "temperament":"Active, Energetic, Independent, Intelligent, Gentle",
 *     "origin":"Egypt",
 *     "country_codes":"EG",
 *     "country_code":"EG",
 *     "life_span":"14 - 15",
 *     "wikipedia_url":"https://en.wikipedia.org/wiki/Abyssinian_(cat)"
 */

data class Breed(
    val weight: Weight,
    val id:String,
    val name: String,
    val temperament: String,
    val origin: String,
    @SerializedName("country_codes")
    val countryCodes: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("life_span")
    val lifeSpan: String,
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String

)
