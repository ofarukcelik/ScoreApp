package com.omerfarukcelik.mackolikdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.omerfarukcelik.mackolikdemo.R
import com.omerfarukcelik.mackolikdemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  lateinit var navController: NavController
  private var isExpand: Boolean = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    navController = findNavController(R.id.nav_host)
    setListeners()
  }

  private fun setListeners() {
    binding.btnArrow.setOnClickListener { expandLayout() }
  }

  private fun expandLayout() {
    binding.layout.visibility = if (isExpand) {
      isExpand = false
      View.GONE
    } else {
      isExpand = true
      View.VISIBLE
    }
  }

  override fun onBackPressed() {
    if (supportFragmentManager.backStackEntryCount > 0) {
      supportFragmentManager.popBackStack()
    } else {
      super.onBackPressed()
    }
  }

  fun onClick(view: View) {
    when(view.id) {
      R.id.txtNews -> {
        navController.navigate(R.id.nav_news)
      }
      R.id.txtScores -> {
        navController.navigate(R.id.nav_score)
      }
    }
  }
}