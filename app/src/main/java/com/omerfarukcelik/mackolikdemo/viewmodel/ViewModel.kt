package com.omerfarukcelik.mackolikdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omerfarukcelik.mackolikdemo.model.news.NewsResponseModel
import com.omerfarukcelik.mackolikdemo.model.scores.ScoresResponseModel
import com.omerfarukcelik.mackolikdemo.repository.Repository
import com.omerfarukcelik.mackolikdemo.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
  private val newsResponseDataState: MutableLiveData<Resource<NewsResponseModel>> = MutableLiveData()
  val newsResponse: LiveData<Resource<NewsResponseModel>> get() = newsResponseDataState
  private val matchesResponseDataState: MutableLiveData<Resource<ScoresResponseModel>> = MutableLiveData()
  val matchesResponse: LiveData<Resource<ScoresResponseModel>> get() = matchesResponseDataState


  fun getNews() = viewModelScope.launch {
    newsResponseDataState.value = repository.getNews()
  }

  fun getMatches() = viewModelScope.launch {
    matchesResponseDataState.value = repository.getMatches()
  }
}