package com.example.filmappproject.ui.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.filmappproject.adapters.OnBoardingPagerAdapter
import com.example.filmappproject.databinding.FragmentViewPagerBinding
import com.example.filmappproject.ui.onboarding.FirstScreen
import com.example.filmappproject.ui.onboarding.SecondScreen
import com.example.filmappproject.ui.onboarding.ThirdScreen

class ViewPagerFragment : Fragment() {
    lateinit var mBinding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentViewPagerBinding.inflate(inflater, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = OnBoardingPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        mBinding.viewPager2.adapter = adapter

        return mBinding.root
    }
}
