package com.example.blogcomments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGetData.setOnClickListener {
            val intent = Intent(this, BlogCommentsActivity::class.java)
            intent.putExtra("id", blogId.text.toString())
            startActivity(intent)
        }
    }
}