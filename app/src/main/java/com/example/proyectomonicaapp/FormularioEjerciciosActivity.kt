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

    private var nameExerciseEdit: String?=null
    enum class Params{
        NAME_EXERCISE;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioEjerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dayOfWeek = intent.getIntExtra(DayActivity.DAY_OF_WEEK, 0)


        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        //MODIFICAR
        nameExerciseEdit = intent.extras?.getString(Params.NAME_EXERCISE.name)

        nameExerciseEdit?.let { nameExerciseEdit ->
            binding.guardarButton.text = "Modificar"
            db.exerciseDao().findByName(nameExerciseEdit)?.let { exercise ->
                binding.nomEjerEditTextText.setText(exercise.name.toString())
                binding.tiempoTextText.setText(exercise.time.toString())
                binding.editTextTextMultiLine.setText(exercise.description.toString())
            }
        }



        binding.volverButton.setOnClickListener {
            val intent = Intent(this, VentanaDiasActivity::class.java)
            startActivity(intent)
        }
        binding.guardarButton.setOnClickListener {
            val name = binding.nomEjerEditTextText.text.toString()
            val time = binding.tiempoTextText.text.toString()
            val description = binding.editTextTextMultiLine.text.toString()

            val exercise = Exercise(
                name = name,
                time = time,
                description = description,
                day = dayOfWeek
            )
            db
                .exerciseDao()
                .save(exercise)
            finish()
        }



    }
}
