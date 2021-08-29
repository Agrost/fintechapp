package com.example.gifViewing.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gifViewing.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val demoCollectionAdapter = ViewPagerAdapter(this)
        pager.adapter = demoCollectionAdapter
        TabLayoutMediator(tab_layout, pager) { tab, position ->
            when (position) {
                0 -> tab.setText(R.string.random)
                1 -> tab.setText(R.string.last)
                2 -> tab.setText(R.string.best)
                3 -> tab.setText(R.string.hot)
                else -> tab.setText(R.string.last)
            }
        }.attach()
    }
}