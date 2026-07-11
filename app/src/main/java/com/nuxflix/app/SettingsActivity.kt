package com.nuxflix.app

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val btnBack: ImageButton = findViewById(R.id.btn_settings_back)
        val switchNotifications: Switch = findViewById(R.id.switch_notifications)
        val switchAutoPlay: Switch = findViewById(R.id.switch_autoplay)
        val switchDarkMode: Switch = findViewById(R.id.switch_darkmode)
        val textQuality: TextView = findViewById(R.id.settings_quality_value)
        val textLanguage: TextView = findViewById(R.id.settings_language_value)
        val textCache: View = findViewById(R.id.settings_cache)
        val textAbout: View = findViewById(R.id.settings_about)
        val textLogout: TextView = findViewById(R.id.settings_logout)

        btnBack.setOnClickListener { finish() }

        textQuality.setOnClickListener {
            val qualities = arrayOf("360p", "480p", "720p", "1080p", "4K")
            AlertDialog.Builder(this).setTitle("جودة التحميل الافتراضية")
                .setSingleChoiceItems(qualities, 2) { dialog, which ->
                    textQuality.text = qualities[which]; dialog.dismiss()
                }.setNegativeButton("إلغاء", null).show()
        }

        textLanguage.setOnClickListener {
            val languages = arrayOf("العربية", "English", "Français")
            AlertDialog.Builder(this).setTitle("لغة التطبيق")
                .setSingleChoiceItems(languages, 0) { dialog, which ->
                    textLanguage.text = languages[which]; dialog.dismiss()
                }.setNegativeButton("إلغاء", null).show()
        }

        textCache.setOnClickListener {
            AlertDialog.Builder(this).setTitle("مسح الذاكرة المؤقتة")
                .setMessage("سيتم مسح جميع الملفات المؤقتة. هل أنت متأكد؟")
                .setPositiveButton("نعم") { _, _ -> Toast.makeText(this, "تم المسح", Toast.LENGTH_SHORT).show() }
                .setNegativeButton("إلغاء", null).show()
        }

        textAbout.setOnClickListener {
            AlertDialog.Builder(this).setTitle("حول التطبيق")
                .setMessage("NuxFlix v1.0\nمنصة أفلام متطورة\n© 2026")
                .setPositiveButton("حسناً", null).show()
        }

        textLogout.setOnClickListener {
            AlertDialog.Builder(this).setTitle("تسجيل الخروج")
                .setMessage("هل تريد تسجيل الخروج؟")
                .setPositiveButton("نعم") { _, _ -> Toast.makeText(this, "تم تسجيل الخروج", Toast.LENGTH_SHORT).show(); finish() }
                .setNegativeButton("إلغاء", null).show()
        }
    }
}
