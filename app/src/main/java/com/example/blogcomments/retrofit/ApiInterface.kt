package com.example.restapi.retrofit

import com.example.blogcomments.model.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("blogEntry.comments")
    fun getClasses(@Query("blogEntryId") id: Int) : Call<Model>
}