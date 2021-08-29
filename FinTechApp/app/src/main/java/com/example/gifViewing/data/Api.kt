package com.example.gifViewing.data

import com.example.gifViewing.data.dto.JsonResponse
import com.example.gifViewing.data.dto.PostDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface Api {
    @GET("latest/{numberOfPage}?json=true")
    fun getLatest(@Path("numberOfPage") numberOfPage: Int): Single<JsonResponse>

    @GET("top/{numberOfPage}?json=true")
    fun getBest(@Path("numberOfPage") numberOfPage: Int): Single<JsonResponse>

    @GET("hot/{numberOfPage}?json=true")
    fun getHot(@Path("numberOfPage") numberOfPage: Int): Single<JsonResponse>

    @GET("random?json=true")
    fun getRandom(): Single<PostDto>
}