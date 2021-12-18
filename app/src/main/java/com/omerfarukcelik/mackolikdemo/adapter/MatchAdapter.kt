package com.omerfarukcelik.mackolikdemo.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.omerfarukcelik.mackolikdemo.R
import com.omerfarukcelik.mackolikdemo.model.scores.Matches

class MatchAdapter(private var matches: List<Matches>): RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

  inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var scoreLayout: LinearLayout = view.findViewById(R.id.scoreLayout)
    var txtHomeTeam: TextView = view.findViewById(R.id.homeTeam)
    var txtAwayTeam: TextView = view.findViewById(R.id.awayTeam)
    var txtScore: TextView = view.findViewById(R.id.txtScore)
    fun bindItems(matches: Matches) {
      txtHomeTeam.text = matches.team_A.name
      txtAwayTeam.text = matches.team_B.name
      txtScore.text = String.format("%s - %s", matches.fts_A, matches.fts_B)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.matches_list_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    if (position %2 == 1) {
      holder.scoreLayout.setBackgroundColor(Color.LTGRAY)
    }
    holder.bindItems(matches[position])
  }

  override fun getItemCount() = matches.size
}