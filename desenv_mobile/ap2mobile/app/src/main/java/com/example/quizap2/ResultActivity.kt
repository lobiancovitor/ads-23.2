package com.example.quizap2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Questions.USER_NAME)
        val totalQuestions = intent.getIntExtra(Questions.TOTAL_QUESTIONS, 0)
        val score = intent.getIntExtra(Questions.SCORE, 0)

        val resultTv: TextView = findViewById(R.id.resultTv)
        val scoreTv: TextView = findViewById(R.id.scoreTv)
        val btnRestart: Button = findViewById(R.id.btnRestart)
        val btnPokemonWebsite = findViewById<Button>(R.id.btnPokemonWebsite)

        resultTv.text = "Resultado de $userName!"
        scoreTv.text = "Você acertou $score de $totalQuestions"
        btnRestart.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnPokemonWebsite.setOnClickListener {
            val pokemonWebsiteUrl = "https://www.pokemon.com/br/pokedex/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pokemonWebsiteUrl))
            startActivity(intent)
        }
    }
}