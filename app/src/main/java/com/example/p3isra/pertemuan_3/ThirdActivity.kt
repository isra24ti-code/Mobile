package com.example.p3isra.pertemuan_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.e
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.p3isra.R
import com.example.p3isra.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_third)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnKirim.setOnClickListener {
            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)


            val nomor = binding.InputNoTujuan.text
            e("Klik btnSubmit","Tombol berhasil di tekan. Isi dari inputNama = $nomor")

            Toast.makeText(this, "Pesan Berhasil di kirim ke $nomor", Toast.LENGTH_SHORT).show()

        }

    }
}