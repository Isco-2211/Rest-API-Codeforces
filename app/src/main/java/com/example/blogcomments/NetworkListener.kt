package com.example.blogcomments

import com.example.blogcomments.model.Result

interface NetworkListener {
    fun onSchoolClassesResponse (models: List<Result>?)
    fun onSchoolClassesFailure(message: String?)
}