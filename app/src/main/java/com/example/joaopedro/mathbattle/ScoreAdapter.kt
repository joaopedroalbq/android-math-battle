package com.example.joaopedro.mathbattle

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ScoreAdapter(var context: Context): BaseAdapter() {
    private lateinit var DAO: ScoreDAO
    private lateinit var queryResults: ArrayList<Score>

    init {
        this.DAO = ScoreDAO(context)
        this.queryResults = this.DAO.read()
    }

    override fun getCount(): Int {
        return this.queryResults.size
    }

    override fun getItem(position: Int): Any {
        return this.queryResults[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val Score = this.queryResults[position]
        val layout: View

        if (convertView == null){
            layout = View.inflate(context, R.layout.score_layout, null)
        }else{
            layout = convertView
        }


        val tvName = layout.findViewById<TextView>(R.id.tvSBName)
        val tvScore = layout.findViewById<TextView>(R.id.tvSBScore)

        tvName.text = Score.getName().toString()
        tvScore.text = Score.getAmount().toString()

        return layout
    }
    
}