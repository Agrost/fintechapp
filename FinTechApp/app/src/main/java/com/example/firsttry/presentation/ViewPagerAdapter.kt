package com.example.firsttry.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firsttry.presentation.fragments.HotFragment
import com.example.firsttry.presentation.fragments.LatestFragment
import com.example.firsttry.presentation.fragments.RandomFragment
import com.example.firsttry.presentation.fragments.BestFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> RandomFragment()
            1 -> LatestFragment()
            2 -> BestFragment()
            3 -> HotFragment()
            else -> LatestFragment()
        }
    }
}