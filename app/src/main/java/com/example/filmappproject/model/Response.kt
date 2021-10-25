package com.example.filmappproject.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

// Code with ❤️
// ┌──────────────────────────┐
// │ Created by Eray Belli       │
// │ ──────────────────────── │
// │ erybelli@gmail.com                 │            
// │ ──────────────────────── │
// │ 20.10.2021                  │
// └──────────────────────────┘    

data class Response(
    @SerializedName("Search")
    val films: List<Film>,

    @SerializedName("Response")
    val response : String,

): Serializable

data class  Film(
    @SerializedName("Poster")
    val poster: String,

    @SerializedName("Title")
    val title: String,

    @SerializedName("Type")
    val type: String,

    @SerializedName("Year")
    val year: String,

    @SerializedName("imdbID")
    val imdbID: String

): Serializable
