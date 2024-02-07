package com.example.proyectomonicaapp.database

import androidx.room.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.libraryapp.model.Book
import com.example.libraryapp.database.dao.BookDao
import com.example.libraryapp.database.dao.CustomerDao
import com.example.libraryapp.model.Customer
import com.example.proyectomonicaapp.database.dao.ExerciseDao

@Database(entities = [Exercise::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        val DATABASE_NAME = "Exercise"
    }
    abstract fun exerciseDao(): ExerciseDao


}