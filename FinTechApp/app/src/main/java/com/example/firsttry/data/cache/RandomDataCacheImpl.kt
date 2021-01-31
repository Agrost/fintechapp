package com.example.firsttry.data.cache

import com.example.firsttry.data.dto.PostDto
import com.example.firsttry.data.Answer
import io.reactivex.rxjava3.core.Single

object RandomDataCacheImpl: RandomCache {
    private val posts: ArrayList<PostDto> = ArrayList()
    private var postArrayStep: Int = 0

    override fun nextPost() : Single<Answer> {
        postArrayStep++
        return getPost()
    }

    override fun prevPost() : Single<Answer> {
        postArrayStep--
        return getPost()
    }

    override fun isPrevPostAvailable(): Boolean {
        return postArrayStep > 1
    }

    override fun currentPost() : Single<Answer> {
        return getPost()
    }

    override fun savePost(postDto: PostDto) {
        posts.add(postDto)
    }

    private fun getPost(): Single<Answer> {
        return if (postArrayStep >= posts.size) {
            Single.just(Answer.Failure)
        } else {
            Single.just(Answer.Success(posts[postArrayStep]))
        }
    }

}