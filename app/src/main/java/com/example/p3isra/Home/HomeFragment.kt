package com.example.p3isra.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.p3isra.Home.pertemuan_4.FourthActivity
import com.example.p3isra.Home.pertemuan_5.FifthActivity
import com.example.p3isra.Home.pertemuan_7.SevenActivity
import com.example.p3isra.Home.pertemuan_10.TenthActivity
import com.example.p3isra.databinding.ActivityHomeFragmentBinding
import com.example.p3isra.pertemuan_11.EleventhActivity

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
        // Navigasi ke Pertemuan 11
        binding.btnPertemuan11.setOnClickListener {
            val intent = Intent(requireContext(), EleventhActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}