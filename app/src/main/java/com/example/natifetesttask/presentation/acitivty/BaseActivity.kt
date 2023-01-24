package com.example.natifetesttask.presentation.acitivty

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourcesId())
    }

    abstract fun getLayoutResourcesId(): Int
}