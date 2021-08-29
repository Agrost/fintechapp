package com.example.gifViewing.data.dto

import com.google.gson.annotations.SerializedName

data class JsonResponse(
    @SerializedName("result") val result: List<PostDto>,
)