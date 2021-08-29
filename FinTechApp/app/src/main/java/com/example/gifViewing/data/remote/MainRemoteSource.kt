package com.example.gifViewing.data.remote

import com.example.gifViewing.data.dto.PostDto
import io.reactivex.rxjava3.core.Single

interface MainRemoteSource {
    fun getPostList(pageNum: Int): Single<List<PostDto>>
}