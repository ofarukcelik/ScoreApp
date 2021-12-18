package com.omerfarukcelik.mackolikdemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.omerfarukcelik.mackolikdemo.databinding.NewsDetailFragmentBinding
import com.omerfarukcelik.mackolikdemo.ui.BaseFragment

class NewsDetailFragment: BaseFragment() {
  private lateinit var binding: NewsDetailFragmentBinding
  private val args: NewsDetailFragmentArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = NewsDetailFragmentBinding.inflate(inflater, container, false)
    binding.webView.settings.javaScriptEnabled = true
    binding.webView.loadUrl(args.webUrl)
    return binding.root
  }
}