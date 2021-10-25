package com.example.filmappproject.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.filmappproject.databinding.FragmentSecondScreenBinding
import com.example.filmappproject.ui.viewpager.ViewPagerFragmentDirections
class SecondScreen : Fragment() {
    lateinit var binding: FragmentSecondScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.secondScreenSkip.setOnClickListener {
            val action = ViewPagerFragmentDirections.actionViewPagerFragmentToFilmSearchFragment()
            findNavController().navigate(action)
        }
    }
}
