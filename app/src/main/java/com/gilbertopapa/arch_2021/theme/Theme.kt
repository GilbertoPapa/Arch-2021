package com.gilbertopapa.arch_2021.theme

enum class Theme {
    DAY_ {
        override fun segment() = DAY
    },
    NIGHT_ {
        override fun segment() = NIGHT
    };

    abstract fun segment(): String
}

private const val DAY = "day"
private const val NIGHT = "night"