package com.omerfarukcelik.mackolikdemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.omerfarukcelik.mackolikdemo.adapter.NewsAdapter
import com.omerfarukcelik.mackolikdemo.databinding.FragmentNewsBinding
import com.omerfarukcelik.mackolikdemo.ui.BaseFragment
import com.omerfarukcelik.mackolikdemo.utils.Listeners
import com.omerfarukcelik.mackolikdemo.utils.Resource
import com.omerfarukcelik.mackolikdemo.viewmodel.ViewModel

class NewsFragment : BaseFragment(), Listeners {
  private lateinit var binding: FragmentNewsBinding
  private lateinit var viewModel: ViewModel
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentNewsBinding.inflate(inflater, container, false)
    viewModel = ViewModelProvider(this)[ViewModel::class.java]
    getNews()
    return binding.root
  }


  private fun getNews() {
    viewModel.getNews()
    viewModel.newsResponse.observe(viewLifecycleOwner, {
      when (it) {
        is Resource.Success -> {
          binding.recyclerView.adapter = NewsAdapter(it.data.news, this)
        }
        else -> {
          it as Resource.Failure
          Toast.makeText(requireContext(), "Error: ${it.errorMessage}", Toast.LENGTH_SHORT).show()
        }
      }
    })
  }

  override fun newsOnItemClick(webUrl: String) {
    var action = NewsFragmentDirections.actionNavNewsToNavNewsDetail(webUrl)
    findNavController().navigate(action)
  }
}