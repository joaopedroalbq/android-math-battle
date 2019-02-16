package com.example.joaopedro.mathbattle

import android.util.Log
import java.util.*

class MathBattle {
    private var x: Int = 0
    private var y: Int = 0
    private var score: Int = 0
    private var operator: String = ""
    private var result: Int = 0
    private var difficulty: Int = 10
    private var timesPlayed: Int = 0
    private var timePenalty: Int = 10

    fun update() {
        timesPlayed++
        raiseDifficulty()
        nextValues()
        nextOperation()
    }

    private fun raiseDifficulty() {
        if(timesPlayed % 5 == 0) {
            difficulty += 10
            timePenalty += 5
        }
    }

    private fun nextValues() {
        val values = Util.randomOperators(difficulty)
        x = values.getAsInteger("x")
        y = values.getAsInteger("y")
    }

    private fun nextOperation() {
        val operation = Util.randomOperation(x, y)
        operator = operation.getAsString("operator")
        result = operation.getAsInteger("result")
    }

    fun getFalseResult(): Int {
        var falseResult = Random().nextInt(difficulty + difficulty)
        return falseResult
    }

    fun updateScore() {
        score += difficulty / 5
    }

    fun getResult(): Int {
        return result
    }

    fun getX(): Int {
        return x
    }

    fun getY(): Int {
        return y
    }

    fun getOperator(): String {
        return operator
    }

    fun getScore(): Int {
        return score
    }

    fun getTimePenalty(): Int {
        return timePenalty
    }

}