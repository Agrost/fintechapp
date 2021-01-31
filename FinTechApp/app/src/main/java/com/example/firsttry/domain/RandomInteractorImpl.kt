package com.example.firsttry.domain

import com.example.firsttry.data.Answer
import com.example.firsttry.data.cache.RandomCache
import com.example.firsttry.data.cache.RandomDataCacheImpl
import com.example.firsttry.data.remote.RandomRemoteSource
import com.example.firsttry.data.remote.RandomRemoteSourceImpl
import com.example.firsttry.DI
import io.reactivex.rxjava3.core.Single

class RandomInteractorImpl : BaseInteractor {
    private val cache: RandomCache = RandomDataCacheImpl
    private val remoteSource: RandomRemoteSource = RandomRemoteSourceImpl(DI.getApi())

    override fun nextPost(): Single<Answer> {
        return cache.nextPost().flatMap {
            if (it == Answer.Failure) {
                remoteSource.getRandom()
                    .map { post -> cache.savePost(post) }.flatMap { cache.currentPost() }
            } else Single.just(it)
        }
    }

    override fun prevPost(): Single<Answer> {
        return cache.prevPost().flatMap {
            if (it == Answer.Failure) {
                remoteSource.getRandom()
                    .map { post -> cache.savePost(post) }.flatMap { cache.currentPost() }
            } else Single.just(it)
        }
    }

    override fun currentPost(): Single<Answer> {
        return cache.currentPost().flatMap {
            if (it == Answer.Failure) {
                remoteSource.getRandom()
                    .map { post -> cache.savePost(post) }.flatMap { cache.currentPost() }
            } else Single.just(it)
        }
    }

    override fun isPrevPostAvailable() = cache.isPrevPostAvailable()
}
