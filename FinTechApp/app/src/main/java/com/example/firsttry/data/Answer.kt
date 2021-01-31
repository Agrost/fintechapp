package com.example.firsttry.data

import com.example.firsttry.data.dto.PostDto

sealed class Answer {
    class Success(val postDto: PostDto?) : Answer()
    object Failure : Answer()
}
