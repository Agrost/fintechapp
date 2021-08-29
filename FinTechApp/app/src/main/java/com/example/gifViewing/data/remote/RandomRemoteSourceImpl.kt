package com.example.gifViewing.data.remote

import com.example.gifViewing.data.Api
import com.example.gifViewing.data.dto.PostDto
import io.reactivex.rxjava3.core.Single

class RandomRemoteSourceImpl(private val api: Api) : RandomRemoteSource {
    override fun getRandom(): Single<PostDto> = api.getRandom()
}