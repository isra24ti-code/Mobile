package com.example.p3isra.Home.pertemuan_7

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.p3isra.R

class SevenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val btn1 = findViewById<Button>(R.id.btnFragment1)
        val btn2 = findViewById<Button>(R.id.btnFragment2)
        val btn3 = findViewById<Button>(R.id.btnFragment3)

        // Tampilkan fragment pertama secara default
        if (savedInstanceState == null) {
            replaceFragment(SatuFragment())
        }

        // Klik tombol tanpa pop-up Toast
        btn1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        btn2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        btn3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}