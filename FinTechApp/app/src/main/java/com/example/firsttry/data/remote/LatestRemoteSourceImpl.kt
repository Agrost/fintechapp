package com.example.firsttry.data.remote

import com.example.firsttry.data.dto.PostDto
import com.example.firsttry.data.Api
import io.reactivex.rxjava3.core.Single

class LatestRemoteSourceImpl(private val api: Api): MainRemoteSource {
    override fun getPost(pageNum: Int): Single<List<PostDto>> = api.getLatest(pageNum).map{it.result}
}