package com.example.examen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.examen.data.Student
import com.example.examen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button2.setOnClickListener {
            val intent = Intent(this, Grup::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            val student = Student(binding.name.text.toString(), binding.group.text.toString(), binding.score.text.toString().toInt())
            Repository.insertStudent(this, student)
            binding.name.text?.clear()
            binding.group.text?.clear()
            binding.score.text?.clear()
        }
    }
}