package com.example.examen.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(student: Student)

    @Query("SELECT * FROM students")
    fun getAll(): List<Student>
}