package com.nuxflix.app

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo: ImageView = findViewById(R.id.splash_logo)

        // إذا حطيت ملف GIF حقيقي فـ res/drawable/splash_logo.gif، فعّل هاذ السطرين
        // وعطّل الأنيميشن الافتراضي تحت:
        // loadRealGif(logo)

        playDefaultLogoAnimation(logo)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, 2200)
    }

    private fun playDefaultLogoAnimation(logo: ImageView) {
        logo.setImageResource(R.drawable.ic_launcher_foreground)
        logo.setColorFilter(resources.getColor(R.color.accent_red, theme))

        val scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0.85f, 1.1f, 0.85f)
        val scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0.85f, 1.1f, 0.85f)
        val rotate = ObjectAnimator.ofFloat(logo, "rotation", 0f, 360f)

        scaleX.repeatCount = ObjectAnimator.INFINITE
        scaleY.repeatCount = ObjectAnimator.INFINITE
        rotate.repeatCount = ObjectAnimator.INFINITE
        rotate.interpolator = LinearInterpolator()
        rotate.duration = 2200

        val set = AnimatorSet()
        set.playTogether(scaleX, scaleY, rotate)
        set.duration = 1100
        set.start()
    }

    private fun loadRealGif(logo: ImageView) {
        Glide.with(this)
            .asGif()
            .load(R.drawable.splash_logo)
            .into(object : CustomTarget<GifDrawable>() {
                override fun onResourceReady(resource: GifDrawable, transition: Transition<in GifDrawable>?) {
                    logo.setImageDrawable(resource)
                    resource.start()
                }
                override fun onLoadCleared(placeholder: android.graphics.drawable.Drawable?) {}
            })
    }
}
