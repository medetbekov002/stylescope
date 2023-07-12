package com.example.stylescope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val pref:Pref by lazy { Pref(applicationContext) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController
        checkOnBoarding()
        initNavController()
    }

    private fun checkOnBoarding() {
        val pref = Pref(this)

        if (pref.showOnBoardingShow()) {
            pref.saveOnBoarding(true)
        } else {
           navController.navigate(R.id.mainFragment)
        }
    }

    private fun initNavController() {

        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val list = ArrayList<Int>()
            list.add(R.id.mainFragment)
            list.add(R.id.pagerFragment)
            list.add(R.id.userNotFavoriteFragment)
            list.add(R.id.favoriteFragment)
            list.add(R.id.profileFragment2)
            list.add(R.id.userNotRegisterFragment)
            list.add(R.id.errorFragment2)
            list.add(R.id.detailDesignerFragment)
            list.add(R.id.detailCompanyFragment)

            if (list.contains(destination.id)) {
                binding.bottomNavigation.visibility = View.VISIBLE
            } else {
                binding.bottomNavigation.visibility = View.GONE
            }
        }
    }


}