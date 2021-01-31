package com.example.firsttry.presentation.fragments

import com.example.firsttry.data.dto.PostDto
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.firsttry.R
import com.example.firsttry.data.Answer
import com.example.firsttry.presentation.viewmodels.BaseViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
        reconnect.setOnClickListener {
            baseViewModel.getCurrentPost()
        }
        prev_gif.setOnClickListener {
            baseViewModel.getPrevPost()
        }
        new_gif.setOnClickListener {
            baseViewModel.getNextPost()
        }
    }

    abstract fun initViewModel()

    private fun observeViewModel() {
        baseViewModel.post.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Answer.Failure -> {
                    errorConnection.isVisible = true
                    successConnection.isVisible = false
                }
                is Answer.Success -> {
                    errorConnection.isVisible = false
                    successConnection.isVisible = true
                    setContent(it.postDto!!)
                }
            }
        })

        baseViewModel.isAvailable.observe(viewLifecycleOwner, Observer {
            when (it) {
                false -> {
                    prev_gif.isEnabled = false
                }
                true -> {
                    prev_gif.isEnabled = true
                }
            }
        })
    }

    private fun setContent(post: PostDto) {
        Glide.with(this)
            .load(post.gifURL)
            .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(8, 0)))
            .into(imageView1)
        textView.text = post.description
    }

    private fun buttonVisible(button: FloatingActionButton, isVisible: Boolean) {
        button.isEnabled = isVisible
        button.isClickable = isVisible
    }
}