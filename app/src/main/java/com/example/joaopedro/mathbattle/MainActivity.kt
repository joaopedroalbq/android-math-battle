package com.example.joaopedro.mathbattle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView


class MainActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    private lateinit var scoreBoard: ListView
    private lateinit var DAO: ScoreDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DAO = ScoreDAO(this)
        scoreBoard = findViewById(R.id.lvScore)
        scoreBoard.adapter = ScoreAdapter(this)

        startButton = findViewById(R.id.btStart)
        startButton.setOnClickListener({startGame(it)})
    }

    fun startGame(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}