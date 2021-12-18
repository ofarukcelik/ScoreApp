package com.omerfarukcelik.mackolikdemo.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object Client {
  var logging = run {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.apply {
      httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }
  }

  var okHttpClient: OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(100, TimeUnit.SECONDS)
    .readTimeout(100, TimeUnit.SECONDS)
    .addInterceptor(logging)
    //.addInterceptor(HeaderInterceptor(cache.getUser()))
    .build()
}