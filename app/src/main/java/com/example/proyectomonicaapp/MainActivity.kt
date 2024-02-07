package com.example.proyectomonicaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectomonicaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.entrarButton.setOnClickListener {
            val intent = Intent(this, VentanaDiasActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Ha iniciado sesión correctamente", Toast.LENGTH_SHORT).show()
        }

    }
}
