package com.asif.mvvmcleanarchitecturekotlin.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.asif.mvvmcleanarchitecturekotlin.R
import com.asif.mvvmcleanarchitecturekotlin.common.showToast
import com.asif.mvvmcleanarchitecturekotlin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy {

        ActivityMainBinding.inflate(layoutInflater)
    }
    private var doubleBackToExitPressedOnce = false

    private val navHost: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
    }
    private val navController: NavController by lazy {
        navHost.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
    }


    override fun onBackPressed() {

        if (navController.currentDestination?.id != R.id.coinListFragment
        ) {
            val navOption = NavOptions.Builder()
                .setPopUpTo(navController.currentDestination?.id!!, true).build()
            navController.navigate(R.id.coinListFragment, null, navOption)
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed()
                return
            }
            doubleBackToExitPressedOnce = true
            val str = getString(R.string.click_back_again_to_exit)
            showToast(str)

            Handler(Looper.getMainLooper()).postDelayed({
                doubleBackToExitPressedOnce = false
            }, 2000)
        }
    }
}