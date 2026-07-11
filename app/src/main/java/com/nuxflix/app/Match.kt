package com.nuxflix.app

data class Match(
    val id: String,
    val homeTeam: String,
    val awayTeam: String,
    val homeScore: String?,
    val awayScore: String?,
    val league: String,
    val time: String,
    val status: String
)
