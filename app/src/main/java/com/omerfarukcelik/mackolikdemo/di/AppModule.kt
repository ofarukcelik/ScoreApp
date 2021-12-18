package com.omerfarukcelik.mackolikdemo.di

import com.omerfarukcelik.mackolikdemo.network.Client
import com.omerfarukcelik.mackolikdemo.network.Service
import com.omerfarukcelik.mackolikdemo.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  private const val BASE_URL = "https://demo1899326.mockable.io/"

  @Singleton
  @Provides
  fun provideService(): Service = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(Client.okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()
    .create(Service::class.java)

  @Singleton
  @Provides
  fun provideRepository(service: Service): Repository = Repository(service)
}