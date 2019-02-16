package com.example.joaopedro.mathbattle

import android.content.ContentValues
import com.example.joaopedro.mathbattle.Arithmetics
import java.util.*

object Util {

    fun randomOperators(max: Int): ContentValues{
        val x = Random().nextInt(max)
        val y = Random().nextInt(max)
        val cv = ContentValues()
        cv.put("x", x)
        cv.put("y", y)
        return cv
    }

    fun randomOperation(x: Int, y: Int): ContentValues {
        val index = Random().nextInt(Arithmetics.values().size)
        val cv = ContentValues()
        cv.put("operator", Arithmetics.values()[index].operator())
        cv.put("result", Arithmetics.values()[index].operation(x, y))
        return cv
    }

}