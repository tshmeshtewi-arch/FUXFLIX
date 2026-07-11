package com.nuxflix.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_results)

        val category = intent.getStringExtra("category_name") ?: "الكل"

        val backBtn: ImageButton = findViewById(R.id.btn_results_back)
        backBtn.setOnClickListener { finish() }

        val titleView: TextView = findViewById(R.id.results_title)
        titleView.text = category

        val recycler: RecyclerView = findViewById(R.id.results_recycler)
        val emptyText: TextView = findViewById(R.id.results_empty_text)
        recycler.layoutManager = GridLayoutManager(this, 2)

        val movies = MovieRepository.getMoviesByCategory(category)
        recycler.adapter = MovieAdapter(movies) { movie ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("movie_id", movie.id)
            startActivity(intent)
        }

        emptyText.visibility = if (movies.isEmpty()) View.VISIBLE else View.GONE
    }
}
