package com.example.proyectomonicaapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectomonicaapp.databinding.ActivityVentanaDiasBinding

class VentanaDiasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVentanaDiasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVentanaDiasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //boton hacia actividad Lunes
        binding.lunesButton.setOnClickListener {
            // Crear un Intent para iniciar la ActivityB
            val intent = Intent (this, LunesActivity::class.java)

            // Iniciar la ActivityB
            startActivity(intent)
        }
        //boton hacia actividad martes
        binding.martesButton.setOnClickListener {
            // Crear un Intent para iniciar la ActivityB
            val intent = Intent (this, FormularioEjerciciosActivity::class.java)
            // Iniciar la ActivityB
            startActivity(intent)
        }
        binding.volverImageButton.setOnClickListener{
           // val intent = Intent(this, MainActivity::class.java)
            finish()
        }
    }
}
