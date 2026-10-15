package com.example.p3isra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.p3isra.Home.HomeFragment
import com.example.p3isra.Message.MessageFragment
import com.example.p3isra.More.MoreFragment
import com.example.p3isra.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Penyesuaian WindowInsets agar BottomNavigation tidak ada jarak di bawah
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        /** HomeFragment sebagai fragment default */
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        // Listener Bottom Navigation sesuai instruksi modul dosen
        binding.bottomNavView.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.message -> {
                    replaceFragment(MessageFragment())
                    true
                }
                R.id.more -> {
                    replaceFragment(MoreFragment())
                    true
                }
                else -> false
            }
        }
    }

    // Fungsi replaceFragment menggunakan binding.fragmentContainer.id
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            // .addToBackStack(null) -> ini dinonaktifkan agar saat tombol back ditekan langsung keluar/tidak menumpuk stack
            .commit()
    }
}