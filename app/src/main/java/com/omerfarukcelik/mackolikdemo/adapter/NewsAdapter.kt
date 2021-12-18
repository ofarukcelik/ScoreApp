package com.omerfarukcelik.mackolikdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omerfarukcelik.mackolikdemo.R
import com.omerfarukcelik.mackolikdemo.model.news.News
import com.omerfarukcelik.mackolikdemo.utils.Listeners

class NewsAdapter(private var newsItems: List<News>, private var listener: Listeners) :
  RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var txtTitle: TextView = view.findViewById(R.id.txtTitle)
    var txtDescription: TextView = view.findViewById(R.id.txtDescription)
    var txtDate: TextView = view.findViewById(R.id.txtDate)
    var image: ImageView = view.findViewById(R.id.image)

    fun bindItems(item: News) {
      txtTitle.text = item.title
      txtDescription.text = item.description
      txtDate.text = item.date
      Glide.with(image).load(item.picUrl).into(image)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bindItems(newsItems[position])
    holder.itemView.setOnClickListener {
      listener.newsOnItemClick(newsItems[position].link)
    }
  }

  override fun getItemCount() = newsItems.size
}