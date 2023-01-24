package com.example.natifetesttask.presentation.acitivty

import android.os.Bundle
import com.example.natifetesttask.R
import com.example.natifetesttask.databinding.ActivityInitialBinding
import com.example.natifetesttask.presentation.navigation.FragmentNavigation

class InitialActivity : BaseActivity(){
    private val binding by viewBinding<ActivityInitialBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initialFlow()
    }

    override fun getLayoutResourcesId(): Int {
        return R.layout.activity_initial
    }

    private fun initialFlow() {
        FragmentNavigation.navigateToSearchGifsFragment(supportFragmentManager)
    }
}