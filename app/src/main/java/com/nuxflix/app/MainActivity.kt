package com.nuxflix.app

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // البحث
    private lateinit var searchInput: EditText
    private lateinit var searchIcon: ImageButton
    private lateinit var brandText: TextView
    private lateinit var emptyText: TextView
    private lateinit var bottomNav: BottomNavigationView

    // الرئيسية (Hero + صفوف)
    private lateinit var heroContainer: View
    private lateinit var heroPoster: ImageView
    private lateinit var heroTitle: TextView
    private lateinit var heroMeta: TextView
    private lateinit var heroPlayBtn: Button

    private lateinit var trendingRecycler: RecyclerView
    private lateinit var latestRecycler: RecyclerView
    private lateinit var searchResultsRecycler: RecyclerView

    private lateinit var trendingAdapter: PosterRowAdapter
    private lateinit var latestAdapter: PosterRowAdapter
    private lateinit var searchAdapter: MovieAdapter

    private var currentQuery: String = ""
    private var featuredMovie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchInput = findViewById(R.id.search_input)
        searchIcon = findViewById(R.id.search_icon)
        brandText = findViewById(R.id.brand_text)
        emptyText = findViewById(R.id.empty_text)
        bottomNav = findViewById(R.id.bottom_nav)

        heroContainer = findViewById(R.id.hero_container)
        heroPoster = findViewById(R.id.hero_poster)
        heroTitle = findViewById(R.id.hero_title)
        heroMeta = findViewById(R.id.hero_meta)
        heroPlayBtn = findViewById(R.id.hero_play_btn)

        trendingRecycler = findViewById(R.id.trending_recycler)
        latestRecycler = findViewById(R.id.latest_recycler)
        searchResultsRecycler = findViewById(R.id.search_results_recycler)

        setupHero()
        setupRows()
        setupSearch()
        setupBottomNav()
        loadHome()
    }

    override fun onResume() {
        super.onResume()
        // ✅ تصحيح مشكلة بقاء لون الزر مفعّل بعد الرجوع من صفحة أخرى:
        // فقط زر "الرئيسية" هو القابل للتحديد، البقية أزرار تنقّل فقط
        bottomNav.menu.findItem(R.id.nav_home).isChecked = true
    }

    private fun setupHero() {
        featuredMovie = MovieRepository.getFeaturedMovies().firstOrNull()
            ?: MovieRepository.getAllMovies().firstOrNull()

        featuredMovie?.let { movie ->
            heroTitle.text = movie.title
            heroMeta.text = "${movie.year}  •  ${movie.duration}  •  ${movie.rating}"
            Glide.with(this)
                .load(movie.posterUrl)
                .placeholder(android.R.color.darker_gray)
                .centerCrop()
                .into(heroPoster)

            val openDetail = View.OnClickListener {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("movie_id", movie.id)
                startActivity(intent)
            }
            heroPoster.setOnClickListener(openDetail)
            heroPlayBtn.setOnClickListener(openDetail)
        }
    }

    private fun setupRows() {
        trendingRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        latestRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        searchResultsRecycler.layoutManager = GridLayoutManager(this, 2)

        val openDetail: (Movie) -> Unit = { movie ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("movie_id", movie.id)
            startActivity(intent)
        }

        trendingAdapter = PosterRowAdapter(emptyList(), openDetail)
        latestAdapter = PosterRowAdapter(emptyList(), openDetail)
        searchAdapter = MovieAdapter(emptyList(), openDetail)

        trendingRecycler.adapter = trendingAdapter
        latestRecycler.adapter = latestAdapter
        searchResultsRecycler.adapter = searchAdapter
    }

    private fun loadHome() {
        val all = MovieRepository.getAllMovies()
        trendingAdapter.updateMovies(all)              // الرائج الآن
        latestAdapter.updateMovies(all.reversed())      // أحدث الإضافات
    }

    private fun setupSearch() {
        searchIcon.setOnClickListener {
            brandText.visibility = View.GONE
            searchInput.visibility = View.VISIBLE
            searchInput.requestFocus()
            searchIcon.visibility = View.GONE
        }

        searchInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                currentQuery = searchInput.text.toString()
                applySearch()
                true
            } else false
        }

        searchInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                currentQuery = s.toString()
                applySearch()
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        searchInput.setOnKeyListener { _, keyCode, event ->
            if (keyCode == android.view.KeyEvent.KEYCODE_BACK && event.action == android.view.KeyEvent.ACTION_UP) {
                hideSearch()
                true
            } else false
        }
    }

    private fun applySearch() {
        if (currentQuery.isBlank()) {
            showHomeSections()
            return
        }
        val results = MovieRepository.searchMovies(currentQuery)
        showSearchResults(results)
    }

    private fun showHomeSections() {
        heroContainer.visibility = View.VISIBLE
        trendingRecycler.visibility = View.VISIBLE
        latestRecycler.visibility = View.VISIBLE
        searchResultsRecycler.visibility = View.GONE
        emptyText.visibility = View.GONE
    }

    private fun showSearchResults(results: List<Movie>) {
        heroContainer.visibility = View.GONE
        trendingRecycler.visibility = View.GONE
        latestRecycler.visibility = View.GONE
        searchResultsRecycler.visibility = View.VISIBLE
        searchAdapter.updateMovies(results)
        emptyText.visibility = if (results.isEmpty()) View.VISIBLE else View.GONE
    }

    private fun hideSearch() {
        searchInput.visibility = View.GONE
        searchIcon.visibility = View.VISIBLE
        brandText.visibility = View.VISIBLE
        searchInput.text.clear()
        currentQuery = ""
        showHomeSections()
    }

    override fun onBackPressed() {
        if (searchInput.visibility == View.VISIBLE) {
            hideSearch()
        } else {
            super.onBackPressed()
        }
    }

    private fun setupBottomNav() {
        // ✅ فقط "الرئيسية" قابل للبقاء محددًا (checkable)
        // الباقي أزرار تنقّل لصفحات أخرى، لذلك لا يجب أن يبقى لونها أحمر بعد الخروج
        listOf(R.id.nav_categories, R.id.nav_football, R.id.nav_downloads, R.id.nav_settings, R.id.nav_account)
            .forEach { id -> bottomNav.menu.findItem(id).isCheckable = false }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    hideSearch()
                    showHomeSections()
                    true
                }
                R.id.nav_categories -> {
                    startActivity(Intent(this, CategoriesActivity::class.java))
                    true
                }
                R.id.nav_football -> {
                    startActivity(Intent(this, FootballActivity::class.java))
                    true
                }
                R.id.nav_downloads -> {
                    startActivity(Intent(this, DownloadsActivity::class.java))
                    true
                }
                R.id.nav_settings -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    true
                }
                R.id.nav_account -> {
                    startActivity(Intent(this, AccountActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}
