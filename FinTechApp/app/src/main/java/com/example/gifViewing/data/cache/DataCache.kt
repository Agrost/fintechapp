package com.example.gifViewing.data.cache

import com.example.gifViewing.data.Answer
import com.example.gifViewing.data.dto.PostDto
import io.reactivex.rxjava3.core.Single

open class DataCache {
    private val posts: ArrayList<PostDto> = ArrayList()
    private var pageNum: Int = -1
    private var postArrayStep: Int = 0

    fun getNextPost(): Single<Answer> {
        postArrayStep++
        return getCurrentPost()
    }

    fun getPrevPost(): Single<Answer> {
        postArrayStep--
        return getCurrentPost()
    }

    fun isPrevPostAvailable(): Boolean = (postArrayStep > 1)

    fun getPosition() = pageNum

    fun savePost(postDto: PostDto) {
        posts.add(postDto)
    }

    fun getCurrentPost(): Single<Answer> {
        return if (postArrayStep >= posts.size) {
            pageNum++
            Single.just(Answer.Failure)
        } else {
            Single.just(Answer.Success(posts[postArrayStep]))
        }
    }
}