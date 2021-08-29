package com.example.gifViewing.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gifViewing.presentation.fragments.BestFragment
import com.example.gifViewing.presentation.fragments.HotFragment
import com.example.gifViewing.presentation.fragments.LatestFragment
import com.example.gifViewing.presentation.fragments.RandomFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RandomFragment()
            1 -> LatestFragment()
            2 -> BestFragment()
            3 -> HotFragment()
            else -> LatestFragment()
        }
    }
}