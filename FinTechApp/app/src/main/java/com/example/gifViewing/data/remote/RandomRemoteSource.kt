package com.example.gifViewing.data.remote

import com.example.gifViewing.data.dto.PostDto
import io.reactivex.rxjava3.core.Single

interface RandomRemoteSource {
    fun getRandom(): Single<PostDto>
}