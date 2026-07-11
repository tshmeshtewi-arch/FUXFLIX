package com.nuxflix.app

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DownloadsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloads)

        findViewById<ImageButton>(R.id.btn_downloads_back).setOnClickListener { finish() }
        findViewById<TextView>(R.id.downloads_status).text = "لا توجد تنزيلات حالياً"
    }
}
