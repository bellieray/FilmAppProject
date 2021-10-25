package com.example.filmappproject.ui.dashboard.adapters

import com.example.filmappproject.databinding.ItemFilmCardBinding
import com.example.filmappproject.model.Film
import com.example.filmappproject.util.getImageFromUrl

// Code with ❤️
// ┌──────────────────────────┐
// │ Created by Eray Belli       │
// │ ──────────────────────── │
// │ erybelli@gmail.com                 │            
// │ ──────────────────────── │
// │ 23.10.2021                  │
// └──────────────────────────┘    

class FilmCardViewHolder(val mBinding: ItemFilmCardBinding) {
    fun bind(film: Film) {

        mBinding.imageView.getImageFromUrl(film.poster)
        mBinding.textView3.text = film.title
    }
}
