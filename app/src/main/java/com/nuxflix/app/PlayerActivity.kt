package com.nuxflix.app

import android.app.AlertDialog
import android.net.Uri
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class PlayerActivity : AppCompatActivity() {

    private var player: ExoPlayer? = null
    private lateinit var playerView: PlayerView
    private lateinit var loadingSpinner: ProgressBar
    private lateinit var qualityText: TextView

    private var movie: Movie? = null
    private var currentQuality: String = "720p"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        playerView = findViewById(R.id.player_view)
        loadingSpinner = findViewById(R.id.loading_spinner)
        qualityText = findViewById(R.id.quality_text)

        val movieId = intent.getIntExtra("movie_id", -1)
        movie = MovieRepository.getMovieById(movieId)

        if (movie == null) {
            Toast.makeText(this, "الفيلم غير متوفر", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        qualityText.text = currentQuality
        qualityText.setOnClickListener { showQualityPicker() }

        setupPlayer(movie!!.getVideoUrl(currentQuality))
    }

    private fun setupPlayer(videoUrl: String) {
        player?.release()

        player = ExoPlayer.Builder(this).build().also { exoPlayer ->
            playerView.player = exoPlayer

            val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
            exoPlayer.setMediaItem(mediaItem)

            exoPlayer.addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(playbackState: Int) {
                    when (playbackState) {
                        Player.STATE_BUFFERING -> {
                            loadingSpinner.visibility = android.view.View.VISIBLE
                        }
                        Player.STATE_READY -> {
                            loadingSpinner.visibility = android.view.View.GONE
                        }
                        Player.STATE_ENDED -> {
                            finish()
                        }
                    }
                }
            })

            exoPlayer.prepare()
            exoPlayer.play()
        }
    }

    private fun showQualityPicker() {
        val qualities = movie?.videoUrls?.keys?.toList() ?: listOf("360p", "480p", "720p", "1080p")
        val currentIndex = qualities.indexOf(currentQuality).coerceAtLeast(0)

        AlertDialog.Builder(this)
            .setTitle("اختر جودة الفيديو")
            .setSingleChoiceItems(qualities.toTypedArray(), currentIndex) { dialog, which ->
                currentQuality = qualities[which]
                qualityText.text = currentQuality
                setupPlayer(movie!!.getVideoUrl(currentQuality))
                dialog.dismiss()
            }
            .setNegativeButton("إلغاء", null)
            .show()
    }

    override fun onStop() {
        super.onStop()
        player?.release()
        player = null
    }
}
