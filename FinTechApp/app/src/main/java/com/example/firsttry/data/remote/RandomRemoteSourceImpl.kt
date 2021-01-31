package com.example.firsttry.data.remote

import com.example.firsttry.data.dto.PostDto
import com.example.firsttry.data.Api
import io.reactivex.rxjava3.core.Single

class RandomRemoteSourceImpl(private val api: Api): RandomRemoteSource {
    override fun getRandom(): Single<PostDto> = api.getRandom()
}