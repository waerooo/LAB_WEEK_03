package com.example.lab_week_03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

// Pastikan interface CoffeeListener sudah dibuat
interface CoffeeListener {
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), CoffeeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Jika kamu punya fungsi ini
        setContentView(R.layout.activity_main)

        // Handle edge-to-edge system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragment_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tambahkan ListFragment secara dinamis hanya sekali saat Activity pertama dibuat
        if (savedInstanceState == null) {
            val containerLayout = findViewById<FragmentContainerView>(R.id.fragment_container)
            val listFragment = ListFragment() // Pastikan ListFragment sudah dibuat
            supportFragmentManager.beginTransaction()
                .add(containerLayout.id, listFragment)
                .commit()
        }
    }

    override fun onSelected(id: Int) {
        // Replace fragment dengan DetailFragment dan tambahkan ke back stack
        val containerLayout = findViewById<FragmentContainerView>(R.id.fragment_container)
        val detailFragment = DetailFragment.newInstance(id)
        supportFragmentManager.beginTransaction()
            .replace(containerLayout.id, detailFragment)
            .addToBackStack(null)
            .commit()
    }

    // Fungsi enableEdgeToEdge bisa seperti ini
    private fun enableEdgeToEdge() {
        // Jika ingin mengatur window flags atau transparent status bar, bisa ditambahkan di sini
    }
}