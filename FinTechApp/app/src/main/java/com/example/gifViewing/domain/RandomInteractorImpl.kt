package com.example.gifViewing.domain

import com.example.gifViewing.DI
import com.example.gifViewing.data.Answer
import com.example.gifViewing.data.cache.DataCache
import com.example.gifViewing.data.cache.RandomDataCacheImpl
import com.example.gifViewing.data.remote.RandomRemoteSource
import com.example.gifViewing.data.remote.RandomRemoteSourceImpl
import io.reactivex.rxjava3.core.Single

class RandomInteractorImpl : BaseInteractor {
    private val cache: DataCache = RandomDataCacheImpl
    private val remoteSource: RandomRemoteSource = RandomRemoteSourceImpl(DI.getApi())

    override fun nextPost(): Single<Answer> = getPost(cache.getNextPost())

    override fun prevPost(): Single<Answer> = getPost(cache.getPrevPost())

    override fun currentPost(): Single<Answer> = getPost(cache.getCurrentPost())

    override fun isPrevPostAvailable() = cache.isPrevPostAvailable()

    override fun getPost(postAvailable: Single<Answer>): Single<Answer> {
        return postAvailable.flatMap {
            if (it == Answer.Failure) {
                remoteSource.getRandom()
                    .map { post -> cache.savePost(post) }
                    .flatMap { cache.getCurrentPost() }
            } else Single.just(it)
        }
    }
}
