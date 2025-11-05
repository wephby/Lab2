package com.example.week4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private lateinit var questionText : TextView
    private lateinit var answerText : TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val data: Intent? = result.data
        if (result.resultCode == RESULT_OK && data != null) {
            val question = data.getStringExtra("question_key")
            val answer = data.getStringExtra("answer_key")

            Log.i("MainActivity", "question: $question")
            Log.i("MainActivity", "answer: $answer")

            questionText.text = question
            answerText.text = answer

            questionText.visibility = View.VISIBLE
            answerText.visibility = View.INVISIBLE
        } else {
            Log.i("MainActivity", "Returned null data from AddCardActivity")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val week4=findViewById<ImageView>(R.id.imageView2
        )
        answerText=findViewById<TextView>(R.id.textView)
        questionText=findViewById<TextView>(R.id.question)

        questionText .setOnClickListener {
            questionText.visibility = View.INVISIBLE
            answerText.visibility = View.VISIBLE
        }
        answerText .setOnClickListener {
            questionText.visibility= View.VISIBLE
            answerText.visibility= View.INVISIBLE
        }



        week4.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            resultLauncher.launch(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}