package com.example.gifViewing.data.remote

import com.example.gifViewing.data.Api
import com.example.gifViewing.data.dto.PostDto
import io.reactivex.rxjava3.core.Single

class BestRemoteSourceImpl(private val api: Api) : MainRemoteSource {
    override fun getPostList(pageNum: Int): Single<List<PostDto>> {
        return api.getBest(pageNum).map { it.result }
    }

}