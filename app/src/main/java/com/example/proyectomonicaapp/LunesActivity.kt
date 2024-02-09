package com.example.proyectomonicaapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.proyectomonicaapp.database.AppDatabase
import com.example.proyectomonicaapp.databinding.ActivityLunesBinding
import com.example.proyectomonicaapp.model.Exercise
import java.util.Date

class LunesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLunesBinding
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLunesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()
        createInitialData()
        //para el menu
        setSupportActionBar(binding.menuToolbar)

        binding.exercisesRecyclerView.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)

        binding.exercisesRecyclerView.adapter = EjercicioAdapter(
            db.exerciseDao().list(), this, db
        )

        binding.addExerciseButton.setOnClickListener {
            val createExerciseIntent = Intent(
                this, FormularioEjerciciosActivity::class.java
            )
            startActivity(createExerciseIntent)
        }

    }

    //Añado varios ejercicios al recycler view
    fun createInitialData() {
        db.exerciseDao().save(
            Exercise(1, "Sit up", "15 repeticiones", "Piernas")
        )
        db.exerciseDao().save(
            Exercise(2, "Crunch con piernas elevadas", "15 repeticiones","Piernas")
        )
        db.exerciseDao().save(
            Exercise(3, "Sit up con med ball", "15 repeticiones", "Piernas")
        )
        db.exerciseDao().save(
            Exercise(4, "Elevación de piernas", "15 repeticiones", "Piernas")
        )
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.addExercisesItem -> {
                val intent = Intent(
                    this, FormularioEjerciciosActivity::class.java
                )
                startActivity(intent)
                Toast.makeText(this, "Pulsado añadir", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.backExercisesItem -> {
                val intent = Intent(
                    this, VentanaDiasActivity::class.java
                )
                startActivity(intent)
                Toast.makeText(this, "Pulsado volver", Toast.LENGTH_SHORT).show()
                true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }

    }
}
