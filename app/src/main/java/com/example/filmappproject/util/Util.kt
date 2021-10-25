package com.example.filmappproject.util

import android.annotation.SuppressLint
import android.content.Context
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.filmappproject.R
import com.example.filmappproject.databinding.FragmentFilmDetailBinding
import com.example.filmappproject.model.Film

// Code with ❤️
// ┌──────────────────────────┐
// │ Created by Eray Belli       │
// │ ──────────────────────── │
// │ erybelli@gmail.com                 │            
// │ ──────────────────────── │
// │ 21.10.2021                  │
// └──────────────────────────┘    

fun ImageView.getImageFromUrl(url: String) {
    val circularProgressDrawable = CircularProgressDrawable(this.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    Glide.with(this).load(url).placeholder(circularProgressDrawable).into(this)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun submitWithEnterKey(editText: EditText, sendButton: ImageButton) {
    editText.setOnKeyListener { v, keyCode, event ->

        when {

            // Check if it is the Enter-Key,      Check if the Enter Key was pressed down
            ((keyCode == KeyEvent.KEYCODE_ENTER) && (event.action == KeyEvent.ACTION_DOWN)) -> {

                // perform an action here e.g. a send message button click
                sendButton.performClick()

                // return true
                return@setOnKeyListener true
            }
            else -> false
        }
    }
}

@BindingAdapter("setCustomText")
fun setText(view : TextView, model : Film) {
    view.text =
        "${model.title} was first released in ${model.year}. From the day it came out, it was very liked by the audience. It also broke box office records the year it was released. Despite the fact that many years have passed, the effect left by the ${model.type} has still not passed. "
}






