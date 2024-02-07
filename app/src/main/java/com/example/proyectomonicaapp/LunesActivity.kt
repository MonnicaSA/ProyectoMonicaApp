package com.example.proyectomonicaapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomonicaapp.databinding.ActivityLunesBinding

class LunesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLunesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLunesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //para el menu
        setSupportActionBar(binding.menuToolbar)

        binding.exercisesRecyclerView.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)

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
                Toast.makeText(this, "Pulsado volver", Toast.LENGTH_SHORT).show()
                true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }

    }
}
