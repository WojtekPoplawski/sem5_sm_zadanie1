package com.example.sem5_sm_zadanie1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trueButton = findViewById<Button>(R.id.true_button)
        val falseButton = findViewById<Button>(R.id.false_button)
        val nextButton = findViewById<Button>(R.id.next_button)
        val questionTextView = findViewById<TextView>(R.id.question_text_view)
        val questions = arrayOf(
            Question(R.string.first_question,true),
            Question(R.string.second_question,false),
            Question(R.string.third_question,true),
            Question(R.string.fourth_question,false),
            Question(R.string.fifth_question,true)
        )
        var currentIndex = 0

        fun checkAnswer(answer: Boolean) {
            val correctAnswer = questions[currentIndex].trueAnswer
            var resultMessageId = 0
            if (answer === correctAnswer){
                resultMessageId = R.string.correct
            }else{
                resultMessageId = R.string.incorrect
            }
            Toast.makeText(this,resultMessageId,Toast.LENGTH_SHORT).show()
        }

        trueButton.setOnClickListener(View.OnClickListener() {
                checkAnswer(true)

        })
        falseButton.setOnClickListener(View.OnClickListener() {
                checkAnswer(false)

        })
        fun setNextQuestion(){
            questionTextView.setText(questions[currentIndex].questionId)
        }
        nextButton.setOnClickListener(View.OnClickListener {

                currentIndex=(currentIndex+1)%questions.size
                setNextQuestion()

        })
    }

}