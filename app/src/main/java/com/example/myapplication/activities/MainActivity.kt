package com.example.myapplication.activities

import Adapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.models.Animal
import com.example.myapplication.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), Adapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private val adapter = Adapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding) {
            countryRecycler.adapter = adapter
            countryRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
            searchBtn.setOnClickListener {
                searchAnimals(searchEt.text.toString())
            }
        }
        setContentView(binding.root)

    }

    private fun searchAnimals(query: String) {
        ServiceBuilder.apiService.getAnimals(query).enqueue(object : Callback<List<Animal>> {
            override fun onResponse(call: Call<List<Animal>>, response: Response<List<Animal>>) {
                if (response.isSuccessful) {
                    val animals = response.body()
                    adapter.submitList(animals)
                }
            }

            override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                Log.e("MainActivity", t.message.toString())
            }
        })
    }

    override fun onItemClick(animal: Animal) {
        startDetailActivity(animal)
    }

    private fun startDetailActivity(animal: Animal) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.
        putExtra("animal", animal)
        startActivity(intent)
    }
}



