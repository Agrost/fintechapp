package com.example.firsttry.domain

import com.example.firsttry.data.Answer
import com.example.firsttry.data.cache.MainCache
import com.example.firsttry.data.remote.MainRemoteSource
import io.reactivex.rxjava3.core.Single

class MainInteractor(private val remoteSource: MainRemoteSource, private val cache: MainCache) : BaseInteractor {

    override fun nextPost(): Single<Answer> = cache.nextPost().flatMap {
        if (it == Answer.Failure) {
            remoteSource.getPost(currentPosition())
                .map { it.forEach { post -> cache.savePost(post) } }.flatMap { cache.currentPost() }
        } else Single.just(it)
    }

    override fun prevPost(): Single<Answer> = cache.prevPost().flatMap {
        if (it == Answer.Failure) {
            remoteSource.getPost(currentPosition())
                .map { it.forEach { post -> cache.savePost(post) } }.flatMap { cache.currentPost() }
        } else Single.just(it)
    }

    override fun currentPost() : Single<Answer> = cache.currentPost().flatMap {
        if (it == Answer.Failure) {
            remoteSource.getPost(currentPosition())
                .map { it.forEach { post -> cache.savePost(post) } }.flatMap { cache.currentPost() }
        } else Single.just(it)
    }

    override fun isPrevPostAvailable() = cache.isPrevPostAvailable()

    private fun currentPosition() = cache.getPosition()
}