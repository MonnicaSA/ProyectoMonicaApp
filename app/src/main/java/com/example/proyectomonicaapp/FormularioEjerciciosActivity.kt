package com.example.proyectomonicaapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.proyectomonicaapp.database.AppDatabase
import com.example.proyectomonicaapp.databinding.ActivityFormularioEjerciciosBinding
import com.example.proyectomonicaapp.model.Exercise


class FormularioEjerciciosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioEjerciciosBinding
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioEjerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        binding.volverButton.setOnClickListener {
            val intent = Intent(this, VentanaDiasActivity::class.java)
            startActivity(intent)
        }
        binding.guardarButton.setOnClickListener{
            val name = binding.nomEjerEditTextText.text.toString()
            val time = binding.tiempoTextText.text.toString()
            val description = binding.editTextTextMultiLine.text.toString()

            val exercise = Exercise(
                name = name,
                time = time,
                description = description,
            )
        db
            .exerciseDao()
            .save(exercise)
        finish()
    }

    }
}
