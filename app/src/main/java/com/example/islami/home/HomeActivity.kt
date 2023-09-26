package com.example.islami.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.home.fragments.AskarFragment
import com.example.islami.home.fragments.HadethFragment
import com.example.islami.home.fragments.QuranFragment
import com.example.islami.home.fragments.TasbehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById(R.id.bottom_navigation_par)

        bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.icon_quran -> {
                    pushFragment(QuranFragment())
                }
                R.id.icon_hadesh -> {
                    pushFragment(HadethFragment())
                }
                R.id.icon_sebha -> {
                    pushFragment(TasbehFragment())
                }
                R.id.icon_azker -> {
                    pushFragment(AskarFragment())
                }
            }

            return@OnItemSelectedListener true
        })
        bottomNavigationView.selectedItemId =R.id.icon_quran
    }
    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}