package com.example.blogcomments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.restapi.BlogCommentsAdapter
import com.example.blogcomments.model.Result
import com.example.blogcomments.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_blog_comments.*

class BlogCommentsActivity : AppCompatActivity(), NetworkListener {

    private val adapter: BlogCommentsAdapter = BlogCommentsAdapter()
    private lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_comments)
        rvResult.adapter = adapter
        val id = intent.getStringExtra("id")!!
        networkHelper = NetworkHelper(ApiClient.getClient())
        setData(id.toInt())
    }

    private fun setData(id: Int) {
        networkHelper.getClasses(this, id)
    }

    override fun onSchoolClassesResponse(models: List<Result>?) {
        adapter.models = models!!
    }

    override fun onSchoolClassesFailure(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}