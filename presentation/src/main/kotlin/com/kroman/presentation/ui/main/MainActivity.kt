package com.kroman.presentation.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kroman.presentation.R
import com.kroman.presentation.databinding.ActivityMainBinding
import com.kroman.presentation.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}