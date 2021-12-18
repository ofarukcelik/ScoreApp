package com.omerfarukcelik.mackolikdemo.model.scores

data class Matches(
    val date_time_utc: String,
    val extras: Extras,
    val fts_A: Int,
    val fts_B: Int,
    val hts_A: Int,
    val hts_B: Int,
    val id: Int,
    val match_time: String,
    val status: String,
    val team_A: TeamA,
    val team_B: TeamB
)