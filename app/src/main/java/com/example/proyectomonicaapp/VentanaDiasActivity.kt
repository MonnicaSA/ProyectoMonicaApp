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
        //LUNES
        //boton hacia actividad Lunes
        binding.lunesButton.setOnClickListener {
            // Crear un Intent para iniciar la ActivityB
            val intent = Intent (this, DayActivity::class.java)
            //pasar Lunes
            intent.putExtra(DayActivity.DAY_OF_WEEK, 0)
            // Iniciar la ActivityB
            startActivity(intent)
        }

        //MARTES
        //boton hacia actividad martes
        binding.martesButton.setOnClickListener {
            // Crear un Intent para iniciar la ActivityB
            val intent = Intent (this, DayActivity::class.java)

            //hacer que se vea MARTES
            intent.putExtra(DayActivity.DAY_OF_WEEK,1)
            // Iniciar la ActivityB
            startActivity(intent)
        }

        //MIERCOLES
        binding.miercolesButton.setOnClickListener {
            val intent = Intent (this, DayActivity::class.java)
            intent.putExtra(DayActivity.DAY_OF_WEEK, 2)
            startActivity(intent)
        }


        //JUEVES
        binding.juevesButton.setOnClickListener {
            val intent = Intent (this, DayActivity::class.java)
            intent.putExtra(DayActivity.DAY_OF_WEEK,3)
            startActivity(intent)
        }

        //VIERNES
        binding.viernesButton.setOnClickListener {
            val intent = Intent (this, DayActivity::class.java)
            intent.putExtra(DayActivity.DAY_OF_WEEK, 4)
            startActivity(intent)
        }

        //SABADO
        binding.sabadoButton.setOnClickListener {
            val intent = Intent (this, DayActivity::class.java)
            intent.putExtra(DayActivity.DAY_OF_WEEK, 5)
            startActivity(intent)
        }


        //DOMINGO
        binding.domingoButton.setOnClickListener {
            val intent = Intent (this, DayActivity::class.java)
            intent.putExtra(DayActivity.DAY_OF_WEEK, 6)
            startActivity(intent)
        }


        //BOTON VOLVER
        binding.volverImageButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            finish()
        }
    }
}
