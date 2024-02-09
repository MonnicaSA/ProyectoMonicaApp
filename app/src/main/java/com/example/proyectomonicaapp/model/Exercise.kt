package com.example.proyectomonicaapp.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class Exercise(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("time") val time: String,
    @ColumnInfo("description") val description: String,
  //  @ColumnInfo("spacious") val spacious: String
)
