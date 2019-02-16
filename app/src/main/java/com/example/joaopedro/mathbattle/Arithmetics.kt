package com.example.joaopedro.mathbattle

enum class Arithmetics {

    SUM {
        override fun operation(x: Int, y: Int): Int = x + y
        override fun operator(): String = "+"
    },
    SUB {
        override fun operation(x: Int, y: Int): Int = x - y
        override fun operator(): String = "-"
    },
    MUL {
        override fun operation(x: Int, y: Int): Int = x * y
        override fun operator(): String = "*"
    };
//    DIV {
//        override fun operation(x: Int, y: Int): Int = x / y
//        override fun operator(): String = "/"
//    };

    abstract fun operation(x: Int, y: Int): Int
    abstract fun operator(): String
}