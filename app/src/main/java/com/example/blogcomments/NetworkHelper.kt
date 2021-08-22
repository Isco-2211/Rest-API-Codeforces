package com.example.blogcomments

import com.example.blogcomments.model.Model
import com.example.restapi.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NetworkHelper(private val apiClient: Retrofit) {

    fun getClasses(listener: NetworkListener, id: Int) {
        val call = apiClient.create(ApiInterface::class.java).getClasses(id)
        call.enqueue(object: Callback<Model> {
            override fun onResponse(
                call: Call<Model>?,
                response: Response<Model>?
            ) {
                listener.onSchoolClassesResponse(response?.body()!!.result)
            }
            override fun onFailure(call: Call<Model>?, t: Throwable?) {
                listener.onSchoolClassesFailure(t?.localizedMessage)
            }
        })
    }

}