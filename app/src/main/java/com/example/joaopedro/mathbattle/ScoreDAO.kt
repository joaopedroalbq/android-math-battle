package com.example.joaopedro.mathbattle

import android.content.ContentValues
import android.content.Context
import android.util.Log

class ScoreDAO {
    private lateinit var db: DBHelper
    private val TABLE = "score"

    constructor(context: Context) {
        this.db = DBHelper(context)
    }

    fun add(name: String, score: Int) {
        val cv = ContentValues()
        cv.put("name", name)
        cv.put("amount", score)
        this.db.writableDatabase.insert(TABLE, null, cv)
    }

    fun read(): ArrayList<Score> {
        val columns = arrayOf("name", "amount")
        val cursor = this.db.readableDatabase.query(TABLE, columns, null, null, null, null, "amount DESC")
        val queryResults = ArrayList<Score>()

        if(cursor.count > 0) {
            cursor.moveToFirst()
            do {
                var score = Score()
                score.setName(cursor.getString(cursor.getColumnIndex("name")))
                score.setAmount(cursor.getInt(cursor.getColumnIndex("amount")))
                queryResults.add(score)
            }while(cursor.moveToNext())
        }
        return queryResults
    }


}