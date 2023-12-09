package com.dicoding.endemic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val profileImage = findViewById<ImageView>(R.id.profile_image)
        val namaLengkap = findViewById<TextView>(R.id.namalengkap)
        val email = findViewById<TextView>(R.id.email)

        profileImage.setImageResource(R.drawable.profile)
        namaLengkap.text = getString(R.string.namalengkap)
        email.text = getString(R.string.email)
    }
}
