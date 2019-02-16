package com.example.joaopedro.mathbattle

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, "mathBattle.db", null, 1){

    override fun onCreate(db: SQLiteDatabase?) {

        val sql = "create table if not exists score(" +
                "id integer primary key autoincrement," +
                " name text," +
                " amount integer)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}