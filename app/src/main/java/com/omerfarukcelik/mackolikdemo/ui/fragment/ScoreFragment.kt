package com.omerfarukcelik.mackolikdemo.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.omerfarukcelik.mackolikdemo.adapter.MatchAdapter
import com.omerfarukcelik.mackolikdemo.databinding.FragmentScoresBinding
import com.omerfarukcelik.mackolikdemo.ui.BaseFragment
import com.omerfarukcelik.mackolikdemo.utils.Extensions.formatDate
import com.omerfarukcelik.mackolikdemo.utils.Extensions.getDate
import com.omerfarukcelik.mackolikdemo.utils.Resource
import com.omerfarukcelik.mackolikdemo.viewmodel.ViewModel

class ScoreFragment : BaseFragment() {
  private lateinit var binding: FragmentScoresBinding
  private lateinit var viewModel: ViewModel
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentScoresBinding.inflate(inflater, container, false)
    viewModel = ViewModelProvider(this)[ViewModel::class.java]
    getMatches()
    return binding.root
  }

  private fun getMatches() {
    viewModel.getMatches()
    viewModel.matchesResponse.observe(viewLifecycleOwner, {
      when (it) {
        is Resource.Success -> {
          binding.txtDate.text = it.data.date.getDate().formatDate()
          binding.recyclerView.adapter = MatchAdapter(it.data.matches)
          refreshAfter30Second()
        }
        else -> {
          it as Resource.Failure
          Toast.makeText(requireContext(), "Error: ${it.errorMessage}", Toast.LENGTH_SHORT).show()
        }
      }
    })
  }

  private fun refreshAfter30Second() {
    val handler = Handler()
    val runnable =
      Runnable { getMatches()}
    handler.postDelayed(runnable,30000)
  }
}