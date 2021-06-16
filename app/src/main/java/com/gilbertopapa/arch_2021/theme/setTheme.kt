package com.gilbertopapa.arch_2021.theme

import android.content.Context
import com.gilbertopapa.arch_2021.BuildConfig
import com.gilbertopapa.core.R
import com.gilbertopapa.view.getDrawableResource
import com.google.android.material.bottomnavigation.BottomNavigationView

fun Context.setTheme(navView: BottomNavigationView) {

    when(BuildConfig.FLAVOR){
        Theme.DAY_.segment() -> {
            setTheme(R.style.ThemeDay)
            navView.background = getDrawableResource(R.color.white_F1F6F9, this)
            navView.itemTextColor = getColorStateList(R.color.black)
            navView.itemIconTintList = getColorStateList(R.color.black)
        }
        Theme.NIGHT_.segment() -> {
            setTheme(R.style.ThemeNight)
            navView.background = getDrawableResource(R.color.blue_16213E, this)
            navView.itemTextColor = getColorStateList(R.color.white_F1F6F9)
            navView.itemIconTintList = getColorStateList(R.color.white_F1F6F9)
        }
    }
}