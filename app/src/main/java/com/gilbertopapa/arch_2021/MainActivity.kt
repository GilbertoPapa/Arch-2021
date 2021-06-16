package com.gilbertopapa.arch_2021

import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.gilbertopapa.arch_2021.databinding.ActivityMainBinding
import com.gilbertopapa.arch_2021.theme.setTheme
import com.gilbertopapa.ui.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var navView: BottomNavigationView

    override val inflate: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onResume() {
        super.onResume()
        navView = binding.navView
        setupNavView()
        setupTheme()
    }

    private fun setupNavView() {
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_favorite
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    private fun setupTheme() {
        supportActionBar?.hide()
        setTheme(navView)
    }
}