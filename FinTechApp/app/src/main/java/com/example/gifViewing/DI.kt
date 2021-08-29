package com.example.gifViewing

import com.example.gifViewing.data.cache.BestDataCacheImpl
import com.example.gifViewing.data.cache.HotDataCacheImpl
import com.example.gifViewing.data.cache.DataCache
import com.example.gifViewing.data.cache.LatestDataCacheImpl
import com.example.gifViewing.data.Api
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DI {
    private lateinit var retrofit: Retrofit
    private lateinit var api: Api
    private lateinit var latestCache: DataCache
    private lateinit var bestCache: DataCache
    private lateinit var hotCache: DataCache

    private fun getRetrofit(): Retrofit {
        return if (this::retrofit.isInitialized) {
            retrofit
        } else {
            retrofit = Retrofit.Builder()
                .baseUrl("https://developerslife.ru/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
            retrofit
        }
    }

    fun getApi(): Api {
        if (!this::api.isInitialized) api = getRetrofit().create(Api::class.java)
        return api
    }

    fun getLatestCache(): DataCache {
        if (!this::latestCache.isInitialized) latestCache = LatestDataCacheImpl
        return latestCache
    }

    fun getBestCache(): DataCache {
        if (!this::bestCache.isInitialized) bestCache = BestDataCacheImpl
        return bestCache
    }

    fun getHotCache(): DataCache {
        if (!this::hotCache.isInitialized) hotCache = HotDataCacheImpl
        return hotCache
    }
}