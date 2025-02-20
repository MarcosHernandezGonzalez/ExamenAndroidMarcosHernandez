package com.example.examen

import com.example.examen.data.dataBase
import android.content.Context
import com.example.examen.data.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class Repository {
    companion object {
        var reposiroty_database: dataBase? = null
        var students: List<Student> = listOf()
        private fun startDatabase(context: Context): dataBase {
            return dataBase.getDatabase(context)
        }

        fun insertStudent(context: Context, student: Student){
            reposiroty_database = startDatabase(context)
            CoroutineScope(IO).launch {
                reposiroty_database?.studentDao()?.insert(student)
            }
        }

        fun getAllStudents(context: Context): List<Student>{
            reposiroty_database = startDatabase(context)
            CoroutineScope(IO).launch {
                students = reposiroty_database?.studentDao()?.getAll()!!
            }
            return students
        }
    }
}