package com.example.gifViewing.domain

import com.example.gifViewing.data.Answer
import io.reactivex.rxjava3.core.Single

interface BaseInteractor {
    fun getPost(postAvailable: Single<Answer>): Single<Answer>
    fun nextPost(): Single<Answer>
    fun prevPost(): Single<Answer>
    fun currentPost(): Single<Answer>
    fun isPrevPostAvailable(): Boolean
}