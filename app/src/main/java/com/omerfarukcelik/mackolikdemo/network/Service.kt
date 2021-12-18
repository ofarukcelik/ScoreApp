package com.omerfarukcelik.mackolikdemo.network

import com.omerfarukcelik.mackolikdemo.model.news.NewsResponseModel
import com.omerfarukcelik.mackolikdemo.model.scores.ScoresResponseModel
import retrofit2.http.GET

interface Service {

  @GET("news")
  suspend fun getNews(): NewsResponseModel

  @GET("matches")
  suspend fun getMatches(): ScoresResponseModel
}