package com.example.week4

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val week4=findViewById<ImageView>(R.id.imageView)
        val save=findViewById<ImageView>(R.id.imageView4)
        val question=findViewById<EditText>(R.id.question)
        val answer=findViewById<EditText>(R.id.answer)

        week4.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        save.setOnClickListener {
        val champ1=question.text.toString()
        val champ2=answer.text.toString()
        val data= Intent().apply {
            putExtra("question_key",champ1)
            putExtra("answer_key",champ2)

        }
            setResult(RESULT_OK,data)
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}