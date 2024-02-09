package com.example.proyectomonicaapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyectomonicaapp.database.dao.ExerciseDao
import com.example.proyectomonicaapp.model.Exercise

@Database(entities = [Exercise::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        val DATABASE_NAME = "exercise"
    }
    abstract fun exerciseDao(): ExerciseDao


}