package com.example.filmappproject.api

import com.example.filmappproject.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// Code with ❤️
// ┌──────────────────────────┐
// │ Created by Eray Belli       │
// │ ──────────────────────── │
// │ erybelli@gmail.com                 │            
// │ ──────────────────────── │
// │ 18.10.2021                  │
// └──────────────────────────┘    

interface FilmService {

    @GET("/")
    fun fetchSearch(@Query("s") search: String?, @Query("page") page: String, @Query("apikey") apikey: String): Call<Response>
}
