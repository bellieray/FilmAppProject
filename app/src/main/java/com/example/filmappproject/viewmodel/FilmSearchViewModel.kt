package com.example.filmappproject.viewmodel

import android.app.AlertDialog
import android.app.Application
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.filmappproject.R
import com.example.filmappproject.api.ApiClient
import com.example.filmappproject.databinding.CustomDialogBinding
import com.example.filmappproject.model.Film
import com.example.filmappproject.model.Response
import kotlinx.coroutines.* //
import retrofit2.Call
import retrofit2.Callback
import kotlin.coroutines.CoroutineContext

// Code with ❤️
// ┌──────────────────────────┐
// │ Created by Eray Belli       │
// │ ──────────────────────── │
// │ erybelli@gmail.com                 │            
// │ ──────────────────────── │
// │ 20.10.2021                  │
// └──────────────────────────┘    

class FilmSearchViewModel() : BaseViewModel()
   {
    val movieList = MutableLiveData<List<Film>>()
    val isLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()
    val isHaveSameData = MutableLiveData<Boolean>()

    fun getData( text: String?) {

        isLoading.value = true


        launch {
            withContext(Dispatchers.IO) {
                val call = ApiClient.getInstance().fetchSearch(text, "1", "2a2e58ee")
                call.enqueue(object : Callback<Response> {
                    override fun onResponse(
                        call: Call<Response>,
                        response: retrofit2.Response<Response>
                    ) {

                        if (response.body() != null && response.body()?.response != "False") {
                            movieList.value = response.body()?.films
                            error.value = false
                            isLoading.value = false
                            isHaveSameData.value = true

                        }
                        else {
                            isHaveSameData.value = false
                        }
                    }

                    override fun onFailure(call: Call<Response>, t: Throwable) {
                        error.value = true
                        isLoading.value = false
                    }
                })
            }
        }
    }


}
