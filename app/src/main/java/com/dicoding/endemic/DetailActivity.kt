package com.dicoding.endemic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val animalName = intent.getStringExtra("animal_name")
        val animalLatin = intent.getStringExtra("animal_latin")
        val animalDescription = intent.getStringExtra("animal_description")
        val animalPhoto = intent.getIntExtra("animal_photo", 0)

        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailLatin = findViewById<TextView>(R.id.tv_detail_latin)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.img_detail_photo)

        tvDetailName.text = animalName
        tvDetailLatin.text = animalLatin
        tvDetailDescription.text = animalDescription
        ivDetailPhoto.setImageResource(animalPhoto)

        val btnShare = findViewById<Button>(R.id.action_share)
        btnShare.setOnClickListener {
            val shareText = "Nama: $animalName\nLatin: $animalLatin\nDeskripsi: $animalDescription"

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}