package com.example.p3isra.Home.pertemuan_7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.p3isra.R

class TigaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // PASTI KAN PANGGUL R.layout.fragment_tiga
        return inflater.inflate(R.layout.fragment_tiga, container, false)
    }
}