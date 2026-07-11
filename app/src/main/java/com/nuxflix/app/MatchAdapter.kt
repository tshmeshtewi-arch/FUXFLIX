package com.nuxflix.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MatchAdapter(private var matches: List<Match>) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    fun updateMatches(newMatches: List<Match>) {
        matches = newMatches
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_match, parent, false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(matches[position])
    }

    override fun getItemCount() = matches.size

    class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val league: TextView = itemView.findViewById(R.id.match_league)
        private val homeTeam: TextView = itemView.findViewById(R.id.home_team)
        private val awayTeam: TextView = itemView.findViewById(R.id.away_team)
        private val score: TextView = itemView.findViewById(R.id.match_score)
        private val status: TextView = itemView.findViewById(R.id.match_status)

        fun bind(match: Match) {
            league.text = match.league
            homeTeam.text = match.homeTeam
            awayTeam.text = match.awayTeam
            score.text = if (match.homeScore != null && match.awayScore != null) {
                "${match.homeScore} - ${match.awayScore}"
            } else {
                "vs"
            }
            status.text = "${match.status}  •  ${match.time}"
        }
    }
}
