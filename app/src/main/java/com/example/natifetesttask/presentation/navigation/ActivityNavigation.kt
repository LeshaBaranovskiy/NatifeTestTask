package com.example.natifetesttask.presentation.navigation

import android.content.Context
import android.content.Intent
import com.example.natifetesttask.presentation.acitivty.InitialActivity

object ActivityNavigation {
    fun navigateToInitialActivity(context: Context) {
        val intent = Intent(context, InitialActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        context.startActivity(intent)
    }
}