package com.example.filmappproject.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

// Code with ❤️
// ┌──────────────────────────┐
// │ Created by Eray Belli       │
// │ ──────────────────────── │
// │ erybelli@gmail.com                 │            
// │ ──────────────────────── │
// │ 22.10.2021                  │
// └──────────────────────────┘    

class OnBoardingPagerAdapter(
    list: ArrayList<Fragment>,
    fm: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {

    private val fragmentList: ArrayList<Fragment> = list

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}
