package com.example.p3isra

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.p3isra.databinding.ActivityMainBinding
import com.example.p3isra.pertemuan_4.FourthActivity
import com.example.p3isra.pertemuan_5.FifthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Navigasi ke Pertemuan 4
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this@MainActivity, FourthActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Pertemuan 5
        binding.btnPertemuan5.setOnClickListener {
            val intent = Intent(this@MainActivity, FifthActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Profil Developer
        binding.btnProfile.setOnClickListener {
            val intent = Intent(this@MainActivity, ProfileDeveloperActivity::class.java)
            startActivity(intent)
        }

        // Action Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    // 1. Samakan nama file ke "user_pref" dan bersihkan dengan clear()
                    val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    // 2. Kembali ke AuthActivity & tutup MainActivity
                    val intent = Intent(this@MainActivity, AuthActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }
}