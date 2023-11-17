package com.example.quizap2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputName = findViewById<EditText>(R.id.inputName)
        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            if (inputName.text.isEmpty()) {
                Toast.makeText(this, "Insira seu nome", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra(Questions.USER_NAME, inputName.text.toString())
                startActivity(intent)
            }
        }
    }
}