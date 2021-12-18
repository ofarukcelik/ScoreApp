package com.omerfarukcelik.mackolikdemo.repository

import com.omerfarukcelik.mackolikdemo.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

open class BaseRepository{

  suspend fun <T> apiCall(
    apiCall: suspend () -> T
  ): Resource<T> {
    return withContext(Dispatchers.IO) {
      try {
        Resource.Success(apiCall.invoke())
      }catch (throwable: Throwable) {
        when(throwable) {
          is HttpException -> {
            Resource.Failure(true, throwable.code(), throwable.message)
          }
          else -> {
            Resource.Failure(false, 500, null)
          }
        }
      }
    }
  }
}