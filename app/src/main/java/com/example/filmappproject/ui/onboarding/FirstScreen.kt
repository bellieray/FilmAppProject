package com.example.filmappproject.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.filmappproject.R
import com.example.filmappproject.databinding.FragmentFirstScreenBinding
import com.example.filmappproject.ui.viewpager.ViewPagerFragmentDirections

class FirstScreen : Fragment() {

lateinit var binding : FragmentFirstScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inflate the layout for this fragment


        binding.firstScreenSkip.setOnClickListener {
            val action = ViewPagerFragmentDirections.actionViewPagerFragmentToFilmSearchFragment()
            findNavController().navigate(action)
        }
    }

}