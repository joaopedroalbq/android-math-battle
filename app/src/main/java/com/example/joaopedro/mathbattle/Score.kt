package com.example.joaopedro.mathbattle

class Score {

    private var name: String
    private var amount: Int


    constructor() {
        this.name = ""
        this.amount = 0
    }

    fun getName(): String {
        return this.name
    }

    fun getAmount(): Int {
        return this.amount
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setAmount(amount: Int) {
        this.amount = amount
    }

}