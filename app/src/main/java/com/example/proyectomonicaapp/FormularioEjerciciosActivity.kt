package com.example.proyectomonicaapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectomonicaapp.databinding.ActivityFormularioEjerciciosBinding
import com.example.proyectomonicaapp.databinding.ActivityMainBinding


class FormularioEjerciciosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioEjerciciosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioEjerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.volverButton.setOnClickListener {
            val intent = Intent(this, VentanaDiasActivity::class.java)
            startActivity(intent)


        }


    }
}
