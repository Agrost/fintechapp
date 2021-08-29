package com.example.gifViewing.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.gifViewing.R
import com.example.gifViewing.data.Answer
import com.example.gifViewing.data.dto.PostDto
import com.example.gifViewing.presentation.viewmodels.BaseViewModel
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.fragment_base.*

abstract class BaseFragment : Fragment(R.layout.fragment_base) {
    protected lateinit var baseViewModel: BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        observeViewModel()
        errorConnection.isVisible = false
        baseViewModel.getCurrentPost()
        reconnect.setOnClickListener { baseViewModel.getCurrentPost() }
        prevGif.setOnClickListener { baseViewModel.getPrevPost() }
        newGif.setOnClickListener { baseViewModel.getNextPost() }
    }

    abstract fun initViewModel()

    private fun observeViewModel() {
        baseViewModel.getPost().observe(viewLifecycleOwner, {
            when (it) {
                is Answer.Failure -> {
                    errorConnection.isVisible = true
                    successConnection.isVisible = false
                }
                is Answer.Success -> {
                    errorConnection.isVisible = false
                    successConnection.isVisible = true
                    setContent(it.postDto)
                }
            }
        })

        baseViewModel.getAccessStatus().observe(viewLifecycleOwner, {
            prevGif.isEnabled = it
        })
    }

    private fun setContent(post: PostDto) {
        Glide.with(this)
            .load(post.gifURL)
            .placeholder(R.drawable.animview)
            .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(8, 0)))
            .into(gifView)
        textView.text = post.description
    }
}