package com.example.restapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.blogcomments.R
import com.example.blogcomments.model.Result
import kotlinx.android.synthetic.main.item_blog_comments.view.*

class BlogCommentsAdapter: RecyclerView.Adapter<BlogCommentsAdapter.SchoolClassViewHolder>() {

    var models: List<Result> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class SchoolClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(model: Result) {
            itemView.tvId.text = model.id.toString()
            itemView.tvCreationTimeSeconds.text = model.creationTimeSeconds.toString()
            itemView.tvCommentatorHandle.text = model.commentatorHandle
            itemView.tvLocale.text = model.locale
            itemView.tvText.text = HtmlCompat.fromHtml(model.text, HtmlCompat.FROM_HTML_MODE_COMPACT)
            itemView.tvParentCommentId.text = model.parentCommentId.toString()
            itemView.tvRating.text = model.rating.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolClassViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_blog_comments, parent, false)
        return SchoolClassViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SchoolClassViewHolder, position: Int) {
        holder.populateModel(models.get(position))
    }
    override fun getItemCount(): Int = models.size
}