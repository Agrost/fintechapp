package com.example.gifViewing.domain

import com.example.gifViewing.data.Answer
import com.example.gifViewing.data.cache.DataCache
import com.example.gifViewing.data.remote.MainRemoteSource
import io.reactivex.rxjava3.core.Single

class MainInteractor(private val remoteSource: MainRemoteSource, private val cache: DataCache) :
    BaseInteractor {

    override fun nextPost(): Single<Answer> = getPost(cache.getNextPost())

    override fun prevPost(): Single<Answer> = getPost(cache.getPrevPost())

    override fun currentPost(): Single<Answer> = getPost(cache.getCurrentPost())

    override fun isPrevPostAvailable() = cache.isPrevPostAvailable()

    private fun currentPosition() = cache.getPosition()

    override fun getPost(postAvailable: Single<Answer>): Single<Answer> {
        return postAvailable.flatMap {
            if (it == Answer.Failure) {
                remoteSource.getPostList(currentPosition())
                    .map { posts -> posts.forEach { post -> cache.savePost(post) } }
                    .flatMap { cache.getCurrentPost() }
            } else Single.just(it)
        }
    }
}