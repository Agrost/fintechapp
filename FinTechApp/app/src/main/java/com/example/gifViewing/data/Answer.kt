package com.example.gifViewing.data

import com.example.gifViewing.data.dto.PostDto

sealed class Answer {
    class Success(val postDto: PostDto) : Answer()
    object Failure : Answer()
}
