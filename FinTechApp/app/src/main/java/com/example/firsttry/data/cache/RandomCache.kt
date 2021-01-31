package com.example.firsttry.data.cache

import com.example.firsttry.data.dto.PostDto
import com.example.firsttry.data.Answer
import io.reactivex.rxjava3.core.Single

interface RandomCache {
    fun nextPost() : Single<Answer>
    fun prevPost() : Single<Answer>
    fun currentPost() : Single<Answer>
    fun savePost(postDto: PostDto)
    fun isPrevPostAvailable(): Boolean
}