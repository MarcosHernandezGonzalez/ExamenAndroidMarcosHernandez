package com.example.examen.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    var name: String,
    var group: String,
    var score: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
