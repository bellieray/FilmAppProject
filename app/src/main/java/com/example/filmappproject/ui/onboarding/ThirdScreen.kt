package com.example.filmappproject.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.filmappproject.databinding.FragmentThirdScreenBinding
import com.example.filmappproject.ui.viewpager.ViewPagerFragmentDirections

class ThirdScreen : Fragment() {
  lateinit var  binding : FragmentThirdScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdScreenBinding.inflate(inflater, container, false)
        binding.thirdScreenButton.setOnClickListener {
            val action = ViewPagerFragmentDirections.actionViewPagerFragmentToFilmSearchFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }


}