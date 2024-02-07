package com.example.proyectomonicaapp.database.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.libraryapp.model.Book
import com.example.proyectomonicaapp.model.Exercise

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    fun list(): List<Exercise>

    @Query("DELETE FROM exercise WHERE name=:name")
    fun delete(name: String): Int

    @Query("SELECT * FROM exercise WHERE name=:name")
    fun listAuthorBooks(name: String): List<Exercise>

    @Insert
    fun save(book: Exercise)
}