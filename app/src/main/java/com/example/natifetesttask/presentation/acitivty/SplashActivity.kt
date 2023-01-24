package com.example.natifetesttask.presentation.acitivty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.natifetesttask.R
import com.example.natifetesttask.presentation.navigation.ActivityNavigation

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityNavigation.navigateToInitialActivity(this@SplashActivity)
    }
}