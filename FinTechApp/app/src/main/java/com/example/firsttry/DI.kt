package com.example.firsttry

import com.example.firsttry.data.cache.BestDataCacheImpl
import com.example.firsttry.data.cache.HotDataCacheImpl
import com.example.firsttry.data.cache.MainCache
import com.example.firsttry.data.cache.LatestDataCacheImpl
import com.example.firsttry.data.Api
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DI {

    private lateinit var retrofit: Retrofit

    private lateinit var api: Api

    private lateinit var  latestCache: MainCache
    private lateinit var  bestCache: MainCache
    private lateinit var  hotCache: MainCache

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
        return if (this::api.isInitialized) {
            api
        } else {
            api = getRetrofit().create(Api::class.java)
            api
        }
    }

    fun getLatestCache(): MainCache {
        return if (this::latestCache.isInitialized){
            latestCache
        } else {
            latestCache = LatestDataCacheImpl()
            latestCache
        }
    }

    fun getBestCache(): MainCache {
        return if (this::bestCache.isInitialized){
            bestCache
        } else {
            bestCache = BestDataCacheImpl()
            bestCache
        }
    }

    fun getHotCache(): MainCache {
        return if (this::hotCache.isInitialized){
            hotCache
        } else {
            hotCache = HotDataCacheImpl()
            hotCache
        }
    }
}