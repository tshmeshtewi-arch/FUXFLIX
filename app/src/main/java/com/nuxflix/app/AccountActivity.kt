package com.nuxflix.app

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val btnBack: ImageButton = findViewById(R.id.btn_account_back)
        val btnOpenSettings: ImageButton = findViewById(R.id.btn_open_settings)
        val userName: EditText = findViewById(R.id.account_name)
        val userEmail: EditText = findViewById(R.id.account_email)
        val userPassword: EditText = findViewById(R.id.account_password)
        val btnSave: Button = findViewById(R.id.btn_save_account)
        val btnDelete: TextView = findViewById(R.id.btn_delete_account)

        btnBack.setOnClickListener { finish() }
        btnOpenSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        btnSave.setOnClickListener {
            val name = userName.text.toString()
            val email = userEmail.text.toString()
            if (name.isBlank() || email.isBlank()) {
                Toast.makeText(this, "يرجى ملء جميع الحقول", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "تم حفظ الحساب بنجاح ✓", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        btnDelete.setOnClickListener {
            AlertDialog.Builder(this).setTitle("حذف الحساب")
                .setMessage("هل أنت متأكد؟ لا يمكن التراجع.")
                .setPositiveButton("حذف") { _, _ -> Toast.makeText(this, "تم حذف الحساب", Toast.LENGTH_SHORT).show(); finish() }
                .setNegativeButton("إلغاء", null).show()
        }
    }
}