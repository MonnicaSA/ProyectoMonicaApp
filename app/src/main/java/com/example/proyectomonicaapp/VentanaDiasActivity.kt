package com.example.proyectomonicaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectomonicaapp.databinding.ActivityFormularioEjerciciosBinding
import com.example.proyectomonicaapp.databinding.ActivityVentanaDiasBinding

class VentanaDiasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVentanaDiasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVentanaDiasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lunesButton.setOnClickListener {
            // Crear un Intent para iniciar la ActivityB
            val intent = Intent (this, FormularioEjerciciosActivity::class.java)

            // Iniciar la ActivityB
            startActivity(intent)
        }
    }
}