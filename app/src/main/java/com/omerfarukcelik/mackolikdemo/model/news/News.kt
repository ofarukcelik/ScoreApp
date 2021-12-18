package com.omerfarukcelik.mackolikdemo.model.news

data class News(
    val date: String,
    val description: String,
    val id: Int,
    val link: String,
    val picUrl: String,
    val title: String
)