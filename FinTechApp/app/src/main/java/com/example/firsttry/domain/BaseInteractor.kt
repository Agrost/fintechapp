package com.example.firsttry.domain

import com.example.firsttry.data.Answer
import io.reactivex.rxjava3.core.Single

interface BaseInteractor {
    fun nextPost() : Single<Answer>
    fun prevPost() : Single<Answer>
    fun currentPost() : Single<Answer>
    fun isPrevPostAvailable() : Boolean
}