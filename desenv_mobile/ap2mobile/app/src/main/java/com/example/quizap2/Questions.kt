package com.example.quizap2

object Questions {
    val USER_NAME: String = "user_name"
    val TOTAL_QUESTIONS: String = "total_questions"
    val SCORE: String = "score"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val questionOne = Question(
            1,
            "Quem é esse Pokemon?",
            R.drawable.meowth,
            arrayListOf("Pidgey", "Meowth",
                "Cubone", "Mankey"),
            1,
        )

        val questionTwo = Question(
            2,
            "Quem é esse Pokemon?",
            R.drawable.totodile,
            arrayListOf("Altaria", "Croconaw",
                "Totodile", "Marill"),
            2
        )

        val questionThree = Question(
            3,
            "Quem é esse Pokemon?",
            R.drawable.gengar,
            arrayListOf("Gengar", "Espeon",
                "Lileep", "Ralts"),
            0
        )

        val questionFour = Question(
            4,
            "Quem é esse Pokemon?",
            R.drawable.piplup,
            arrayListOf("Empoleon", "Piplup",
                "Azelf", "Snivy"),
            1
        )

        val questionFive = Question(
            5,
            "Quem é esse Pokemon?",
            R.drawable.umbreon,
            arrayListOf("Charmeleon", "Flareon",
                "Vaporeon", "Umbreon"),
            3
        )

        val questionSix = Question(
            6,
            "Quem é esse Pokemon?",
            R.drawable.darkrai,
            arrayListOf("Darkrai", "Manaphy",
                "Greninja", "Kyurem"),
            0
        )

        questionsList.add(questionOne)
        questionsList.add(questionTwo)
        questionsList.add(questionThree)
        questionsList.add(questionFour)
        questionsList.add(questionFive)
        questionsList.add(questionSix)

        return questionsList
    }
}