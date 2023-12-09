package com.dicoding.endemic

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAnimals: RecyclerView
    private val list = ArrayList<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAnimals = findViewById(R.id.rv_animals)
        rvAnimals.setHasFixedSize(true)
        list.addAll(getListAnimals())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListAnimals(): ArrayList<Animal> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataLatin = resources.getStringArray(R.array.data_latin)
        val dataCategory = resources.getStringArray(R.array.data_category)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listAnimal = ArrayList<Animal>()
        for (i in dataName.indices) {
            val animal = Animal(dataName[i], dataLatin[i], dataCategory[i], dataPhoto.getResourceId(i, -1), dataDescription[i])
            listAnimal.add(animal)
        }
        return listAnimal
    }

    private fun showRecyclerList() {
        rvAnimals.layoutManager = LinearLayoutManager(this)
        val listAnimalAdapter = ListAnimalAdapter(list)
        rvAnimals.adapter = listAnimalAdapter

        listAnimalAdapter.setOnItemClickCallback(object : ListAnimalAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Animal) {
                showSelectedAnimal(data)
            }
        })
    }

    private fun showSelectedAnimal(animal: Animal) {
        val intent = Intent(this, DetailActivity::class.java)

        intent.putExtra("animal_name", animal.name)
        intent.putExtra("animal_latin", animal.latin)
        intent.putExtra("animal_category", animal.category)
        intent.putExtra("animal_photo", animal.photo)
        intent.putExtra("animal_description", animal.description)

        startActivity(intent)
    }

    fun openAboutActivity(item: MenuItem) {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}