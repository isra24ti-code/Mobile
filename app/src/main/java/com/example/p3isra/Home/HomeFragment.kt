package com.example.p3isra.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.p3isra.Home.data.api.CatFactApiClient
import com.example.p3isra.Home.data.api.PhotoApiClient
import com.example.p3isra.Home.pertemuan_4.FourthActivity
import com.example.p3isra.Home.pertemuan_5.FifthActivity
import com.example.p3isra.Home.pertemuan_7.SevenActivity
import com.example.p3isra.Home.pertemuan_10.TenthActivity
import com.example.p3isra.Home.photo.PhotoAdapter
import com.example.p3isra.databinding.ActivityHomeFragmentBinding
import com.example.p3isra.pertemuan_11.EleventhActivity
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.GridLayoutManager

class HomeFragment : Fragment() {

    private var _binding: ActivityHomeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityHomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigasi ke Pertemuan 4
        binding.btnPertemuan4.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Pertemuan 5
        binding.btnPertemuan5.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Pertemuan 7
        binding.btnPertemuan7.setOnClickListener {
            val intent = Intent(requireContext(), SevenActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Pertemuan 10
        binding.btnPertemuan10.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Pertemuan 11
        binding.btnPertemuan11.setOnClickListener {
            val intent = Intent(requireContext(), EleventhActivity::class.java)
            startActivity(intent)
        }

        // Muat Cat Fact saat halaman dibuka
        loadCatFact()

        // Muat ulang Cat Fact saat tombol Refresh diklik
        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }

        // Muat daftar foto ke RecyclerView
        loadPhoto()
    }

    private fun loadCatFact() {
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                val adapter = PhotoAdapter(photos)
                binding.rvGallery.adapter = adapter

                // Menampilkan 2 kolom (grid) seperti di gambar
                binding.rvGallery.layoutManager = GridLayoutManager(requireContext(), 2)
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}