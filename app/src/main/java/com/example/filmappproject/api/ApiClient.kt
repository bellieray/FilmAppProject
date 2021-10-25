package com.example.filmappproject.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Code with ❤️
// ┌──────────────────────────┐
// │ Created by Eray Belli       │
// │ ──────────────────────── │
// │ erybelli@gmail.com                 │            
// │ ──────────────────────── │
// │ 20.10.2021                  │
// └──────────────────────────┘    

object ApiClient {
    private const val BASE_URL = "https://www.omdbapi.com/"

    var filmService: FilmService? = null

    fun getInstance(): FilmService {
        filmService = filmService ?: Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(FilmService::class.java)
        return filmService as FilmService
    }
}
