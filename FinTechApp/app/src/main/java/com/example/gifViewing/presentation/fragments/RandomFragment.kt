package com.example.gifViewing.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.gifViewing.R
import com.example.gifViewing.presentation.viewmodels.RandomViewModel

class RandomFragment : BaseFragment() {
    override fun initViewModel() {
        baseViewModel = ViewModelProvider(this).get(RandomViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }
}