package com.example.proyectomonicaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomonicaapp.database.AppDatabase
import com.example.proyectomonicaapp.databinding.EjercicioLayoutBinding
import com.example.proyectomonicaapp.model.Exercise

class EjercicioAdapter (
    var exercises: List<Exercise>,
    val context: Context,
    val db: AppDatabase,
    val day: Int
    ) :
    RecyclerView.Adapter<EjercicioAdapter.ItemViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            layoutInflater.inflate(R.layout.ejercicio_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val exercise = exercises[position]

        //no me funcionaba porque es EjercicioLayoutBinding
        val binding = EjercicioLayoutBinding.bind(holder.itemView)

        binding.nameTextView.text = exercise.name


        binding.timeTextView.text = exercise.time

        binding.descriptionTextView.text = exercise.description

        binding.deleteImageView.setOnClickListener{
            val deletedRows = db.exerciseDao().delete(exercise.name)

            exercises = db.exerciseDao().list(day)

            notifyDataSetChanged()
            if(deletedRows == 0) {
                Toast.makeText(context, "No se ha eliminado ningún ejercicio", Toast.LENGTH_LONG).show()
            }
        }
    }


}
