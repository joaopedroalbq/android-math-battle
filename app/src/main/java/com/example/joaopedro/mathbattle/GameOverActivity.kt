package com.example.joaopedro.mathbattle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GameOverActivity : AppCompatActivity() {

    private lateinit var tvScore: TextView
    private lateinit var etName: EditText
    private lateinit var score: String
    private lateinit var name: String
    private lateinit var btContinue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gameover_screen)
        score = intent.getStringExtra("SCORE")
        tvScore = findViewById(R.id.tvScore)
        etName = findViewById(R.id.etName)
        tvScore.text = "Your score: " + score
        btContinue = findViewById(R.id.btContinue)
        btContinue.setOnClickListener({saveScore(score.toInt())})
    }

    fun saveScore(score: Int) {
        name = etName.text.toString()
        val DAO = ScoreDAO(this)
        DAO.add(name, score)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
