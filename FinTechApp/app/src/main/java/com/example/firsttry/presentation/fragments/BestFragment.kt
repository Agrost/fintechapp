package com.example.firsttry.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.firsttry.R
import com.example.firsttry.presentation.viewmodels.BaseViewModel
import com.example.firsttry.presentation.viewmodels.BestViewModel

class BestFragment : BaseFragment() {
    override fun initViewModel() {
        baseViewModel = ViewModelProvider(this).get(BestViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }
}