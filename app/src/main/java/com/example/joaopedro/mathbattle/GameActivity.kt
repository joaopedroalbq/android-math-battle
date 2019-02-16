package com.example.joaopedro.mathbattle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.lang.Integer.parseInt
import java.util.*


class GameActivity : AppCompatActivity() {

    private lateinit var x: TextView
    private lateinit var y: TextView
    private lateinit var operator: TextView
    private lateinit var score: TextView
    private lateinit var result: TextView
    private lateinit var timeLeft: ProgressBar
    private lateinit var rightButton: Button
    private lateinit var wrongButton: Button
    private var game = MathBattle()
    private var isGameOver = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_screen)
        score = findViewById(R.id.tvScore)
        x = findViewById(R.id.tvX)
        y = findViewById(R.id.tvY)
        operator = findViewById(R.id.tvOperator)
        result = findViewById(R.id.tvResult)
        timeLeft = findViewById(R.id.pbTimeLeft)
        rightButton = findViewById(R.id.btRight)
        wrongButton = findViewById(R.id.btWrong)
        rightButton.setOnClickListener({evaluate(1)})
        wrongButton.setOnClickListener({evaluate(0)})
        update()
        timer()
    }


    fun evaluate(res: Int) {
        if(isGameOver) return

        if(res == 1 && result.text.toString() == game.getResult().toString()){
            timeLeft.progress += 15
            game.updateScore()
        }

        else if(res == 0 && result.text.toString() != game.getResult().toString()){
            timeLeft.progress += 15
            game.updateScore()
        }

        else timeLeft.progress -= game.getTimePenalty()

        update()
    }

    fun timer() {

        object : CountDownTimer(100000000, 100) {

            override fun onTick(millisUntilFinished: Long) {
                if(timeLeft.progress <= 0 ) {
                    this.cancel()
                    gameOver()
                }
                timeLeft.progress = timeLeft.progress - 1
            }

            override fun onFinish() {
                gameOver()
            }

        }.start()

    }

    fun update() {
        game.update()
        x.text = game.getX().toString()
        y.text = game.getY().toString()
        operator.text = game.getOperator()
        result.text = game.getResult().toString()
        score.text = game.getScore().toString()
        if(Random().nextBoolean()) {
            result.text = Random().nextInt(game.getFalseResult()).toString()
        }
    }

    fun gameOver() {
        isGameOver = true
        val intent = Intent(this, GameOverActivity::class.java)
        intent.putExtra("SCORE", score.text.toString())
        startActivity(intent)
    }
}
