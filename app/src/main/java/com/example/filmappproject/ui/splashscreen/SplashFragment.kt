package com.example.filmappproject.ui.splashscreen

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.filmappproject.R
import kotlinx.coroutines.*


class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        runBlocking {
            CoroutineScope(Dispatchers.Main).launch {
                delay(3000)

                val editor: SharedPreferences =  requireContext().getSharedPreferences("Onboarding", MODE_PRIVATE)
                if(editor.getBoolean("isShow",true)){
                    findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)

                    val edit =  requireContext().getSharedPreferences("Onboarding", MODE_PRIVATE).edit();
                    edit.putBoolean("isShow",false)
                    edit.apply()
                }
                else {
                    findNavController().navigate(R.id.action_splashFragment_to_filmSearchFragment)
                }


            }
        }



        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
}
