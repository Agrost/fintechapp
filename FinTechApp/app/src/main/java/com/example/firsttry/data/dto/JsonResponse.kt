package com.example.firsttry.data.dto

import com.google.gson.annotations.SerializedName

data class JsonResponse (
    @SerializedName("result") val result : List<PostDto>
)