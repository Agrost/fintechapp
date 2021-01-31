package com.example.firsttry.data.remote

import com.example.firsttry.data.dto.PostDto
import io.reactivex.rxjava3.core.Single

interface MainRemoteSource {
    fun getPost(pageNum: Int): Single<List<PostDto>>
}