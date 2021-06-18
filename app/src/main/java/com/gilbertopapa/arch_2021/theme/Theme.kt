package com.gilbertopapa.arch_2021.theme

enum class Theme {
    THEME_DAY {
        override fun segment() = DAY
    },
    THEME_NIGHT {
        override fun segment() = NIGHT
    };

    abstract fun segment(): String
}

private const val DAY = "day"
private const val NIGHT = "night"