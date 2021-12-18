package com.omerfarukcelik.mackolikdemo.repository

import com.omerfarukcelik.mackolikdemo.network.Service
import javax.inject.Inject

class Repository @Inject constructor(private var service: Service) : BaseRepository() {
  suspend fun getNews() = apiCall { service.getNews() }
  suspend fun getMatches() = apiCall { service.getMatches() }
}