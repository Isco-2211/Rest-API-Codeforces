package com.example.blogcomments.model

data class Result(
    val commentatorHandle: String,
    val creationTimeSeconds: Int,
    val id: Int,
    val locale: String,
    val parentCommentId: Int,
    val rating: Int,
    val text: String
)