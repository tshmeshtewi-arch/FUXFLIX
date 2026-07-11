package com.nuxflix.app

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.Executors

/**
 * صفحة الكورة — نسخة بداية (Beginner) تعتمد على API مجاني عام (TheSportsDB - المفتاح التجريبي "3")
 * ملاحظة: هذا API مجاني للتجربة وليس رسمي، لذلك قد يتأخر التحديث أحياناً.
 * لاحقاً يمكن استبداله بأي API رسمي (مثل football-data.org) بتغيير BASE_URL و apiKey فقط.
 */
class FootballActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var progress: ProgressBar
    private lateinit var emptyText: TextView
    private lateinit var adapter: MatchAdapter

    private val executor = Executors.newSingleThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football)

        val backBtn: ImageButton = findViewById(R.id.btn_football_back)
        backBtn.setOnClickListener { finish() }

        recycler = findViewById(R.id.matches_recycler)
        progress = findViewById(R.id.football_progress)
        emptyText = findViewById(R.id.football_empty_text)

        recycler.layoutManager = LinearLayoutManager(this)
        adapter = MatchAdapter(emptyList())
        recycler.adapter = adapter

        loadMatches(daysAgo = 0)
    }

    /** يجلب مباريات اليوم، وإذا كانت فارغة يجرب الأمس تلقائياً (لأن أغلب البطولات لا تلعب يومياً) */
    private fun loadMatches(daysAgo: Int) {
        progress.visibility = View.VISIBLE
        emptyText.visibility = View.GONE

        executor.execute {
            val dateStr = dateBefore(daysAgo)
            val result = fetchMatches(dateStr)

            runOnUiThread {
                progress.visibility = View.GONE
                if (result.isEmpty() && daysAgo == 0) {
                    // ما فيش مباريات اليوم -> نجرب البارح
                    loadMatches(daysAgo = 1)
                } else {
                    adapter.updateMatches(result)
                    emptyText.visibility = if (result.isEmpty()) View.VISIBLE else View.GONE
                }
            }
        }
    }

    private fun dateBefore(days: Int): String {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_YEAR, -days)
        val fmt = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        return fmt.format(cal.time)
    }

    /** طلب شبكي بسيط بدون مكتبات إضافية (HttpURLConnection) */
    private fun fetchMatches(date: String): List<Match> {
        return try {
            val urlStr = "https://www.thesportsdb.com/api/v1/json/3/eventsday.php?d=$date&s=Soccer"
            val url = URL(urlStr)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.connectTimeout = 10000
            conn.readTimeout = 10000

            val responseCode = conn.responseCode
            if (responseCode != HttpURLConnection.HTTP_OK) return emptyList()

            val body = conn.inputStream.bufferedReader().use { it.readText() }
            parseMatches(body)
        } catch (e: Exception) {
            emptyList()
        }
    }

    private fun parseMatches(json: String): List<Match> {
        val matches = mutableListOf<Match>()
        try {
            val root = JSONObject(json)
            val events: JSONArray = root.optJSONArray("events") ?: return emptyList()
            for (i in 0 until events.length()) {
                val e = events.getJSONObject(i)
                matches.add(
                    Match(
                        id = e.optString("idEvent"),
                        homeTeam = e.optString("strHomeTeam"),
                        awayTeam = e.optString("strAwayTeam"),
                        homeScore = e.optString("intHomeScore").takeIf { it != "null" && it.isNotBlank() },
                        awayScore = e.optString("intAwayScore").takeIf { it != "null" && it.isNotBlank() },
                        league = e.optString("strLeague"),
                        time = e.optString("strTime").ifBlank { "--:--" },
                        status = e.optString("strStatus").ifBlank { "مجدولة" }
                    )
                )
            }
        } catch (e: Exception) {
            // تجاهل أي خطأ في التحليل ونرجع قائمة فارغة
        }
        return matches
    }

    override fun onDestroy() {
        super.onDestroy()
        executor.shutdown()
    }
}
