package com.nuxflix.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * أداپتر خفيف لعرض بوسترات أفقية (صفوف "الرائج الآن" و"أحدث الإضافات")
 * بنفس أسلوب التصميم المطلوب
 */
class PosterRowAdapter(
    private var movies: List<Movie>,
    private val onItemClick: (Movie) -> Unit
) : RecyclerView.Adapter<PosterRowAdapter.PosterViewHolder>() {

    fun updateMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_poster_small, parent, false)
        return PosterViewHolder(view)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { onItemClick(movie) }
    }

    override fun getItemCount() = movies.size

    class PosterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val posterView: ImageView = itemView.findViewById(R.id.poster_view)
        private val titleView: TextView = itemView.findViewById(R.id.movie_title)
        private val ratingBadge: TextView = itemView.findViewById(R.id.rating_badge)

        fun bind(movie: Movie) {
            titleView.text = movie.title
            ratingBadge.text = movie.rating
            Glide.with(itemView.context)
                .load(movie.posterUrl)
                .placeholder(android.R.color.darker_gray)
                .centerCrop()
                .into(posterView)
        }
    }
}
