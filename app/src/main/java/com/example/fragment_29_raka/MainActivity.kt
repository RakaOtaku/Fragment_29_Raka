package com.example.fragment_29_raka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment_29_raka.fragment.ChatFragment
import com.example.fragment_29_raka.fragment.HomeFragment
import com.example.fragment_29_raka.fragment.ProfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val chatFragment = ChatFragment()
        val profilFragment = ProfilFragment()

        makeCurrentFragment(homeFragment)

        val buttom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        buttom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_chat -> makeCurrentFragment(chatFragment)
                R.id.menu_profile -> makeCurrentFragment(profilFragment)
            }

            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }
    }
}