package com.example.proyectomonicaapp.database.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.proyectomonicaapp.model.Exercise

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise WHERE day=:day")
    fun list(day: Int): List<Exercise>

    @Query("DELETE FROM exercise WHERE name=:name")
    fun delete(name: String): Int

    @Query("SELECT * FROM exercise WHERE name=:name")
    fun listNameExercises(name: String): List<Exercise>

    @Insert
    fun save(exercise: Exercise)
}