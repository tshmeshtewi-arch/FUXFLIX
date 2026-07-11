package com.nuxflix.app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        val backBtn: ImageButton = findViewById(R.id.btn_categories_back)
        backBtn.setOnClickListener { finish() }

        val recycler: RecyclerView = findViewById(R.id.categories_recycler)
        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.adapter = CategoryAdapter(CategoryData.list()) { category ->
            val intent = Intent(this, CategoryResultsActivity::class.java)
            intent.putExtra("category_name", category.name)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
