package com.omerfarukcelik.mackolikdemo.model.scores

data class ScoresResponseModel(
    val date: String,
    val displayRound: Boolean,
    val format: String,
    val groups: List<Any>,
    val matches: List<Matches>,
    val name: String
)