package com.example.gifViewing.data.dto

import com.google.gson.annotations.SerializedName

data class PostDto(
	@SerializedName("description") val description: String,
	@SerializedName("gifURL") val gifURL: String,
)