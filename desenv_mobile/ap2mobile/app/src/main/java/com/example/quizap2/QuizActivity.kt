package com.example.quizap2

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizActivity : AppCompatActivity() {
    private var userName: String? = null

    private val questionsList: ArrayList<Question> = Questions.getQuestions()
    private var currentQuestionIndex = 0;
    private var selectedAlternativeIndex = -1;
    private var isAnswerChecked = false;
    private var totalScore = 0;

    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var tvProgress: TextView? = null
    private var tvAlternatives: ArrayList<TextView>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        userName = intent.getStringExtra(Questions.USER_NAME)

        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        tvProgress = findViewById(R.id.tvProgress)
        tvAlternatives = arrayListOf(
            findViewById(R.id.optionOne),
            findViewById(R.id.optionTwo),
            findViewById(R.id.optionThree),
            findViewById(R.id.optionFour),
        )

        updateQuestion()

        tvAlternatives?.let {
            for (optionIndex in it.indices) {
                it[optionIndex].let {
                    it.setOnClickListener{
                        if (!isAnswerChecked) {
                            selectedAlternativeView(it as TextView, optionIndex)
                            processAnswer()
                        }
                    }
                }
            }
        }
    }

    private fun processAnswer() {
        if (!isAnswerChecked) {
            val anyAnswerIsChecked = selectedAlternativeIndex != -1
            if (anyAnswerIsChecked) {
                val currentQuestion = questionsList[currentQuestionIndex]
                if (selectedAlternativeIndex == currentQuestion.correctAnswerIndex) {
                    totalScore++
                }
                isAnswerChecked = true

                if (currentQuestionIndex < questionsList.size - 1) {
                    currentQuestionIndex++
                    updateQuestion()
                } else {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Questions.USER_NAME, userName)
                    intent.putExtra(Questions.TOTAL_QUESTIONS, questionsList.size)
                    intent.putExtra(Questions.SCORE, totalScore)
                    startActivity(intent)
                    finish()
                }

                isAnswerChecked = false
            }
        }
    }

    private fun updateQuestion() {
        tvQuestion?.text = questionsList[currentQuestionIndex].questionText
        ivImage?.setImageResource(questionsList[currentQuestionIndex].image)
        tvProgress?.text = "${currentQuestionIndex + 1}/${questionsList.size}"

        for (alternativeIndex in questionsList[currentQuestionIndex].alternatives.indices) {
            tvAlternatives!![alternativeIndex].text = questionsList[currentQuestionIndex].alternatives[alternativeIndex]
        }
    }

    private fun selectedAlternativeView(option: TextView, index: Int) {
        selectedAlternativeIndex = index
    }
}