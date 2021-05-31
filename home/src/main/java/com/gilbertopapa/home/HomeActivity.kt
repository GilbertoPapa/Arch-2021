package com.gilbertopapa.home

import android.view.LayoutInflater
import com.gilbertopapa.home.databinding.ActivityHomeBinding
import com.gilbertopapa.ui.BaseViewBindingActivity

class HomeActivity : BaseViewBindingActivity<ActivityHomeBinding>() {

    override val inflate: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate
}