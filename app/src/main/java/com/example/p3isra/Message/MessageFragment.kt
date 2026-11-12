package com.example.p3isra.Message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.p3isra.Message.tutorial.TutorialMessageActivity
import com.example.p3isra.R
import com.example.p3isra.databinding.ActivityMessageFragmentBinding

class MessageFragment : Fragment() {

    private var _binding: ActivityMessageFragmentBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://i.pravatar.cc/150?u=Alya"),
        MessageModel("Budi", "Sudah makan?", "https://i.pravatar.cc/150?u=Budi"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://i.pravatar.cc/150?u=Citra"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://i.pravatar.cc/150?u=Dika"),
        MessageModel("Eka", "Nice job kemarin!", "https://i.pravatar.cc/150?u=Eka"),
        MessageModel("Fajar", "Lagi ngapain?", "https://i.pravatar.cc/150?u=Fajar"),
        MessageModel("Gita", "Boleh minta tolong?", "https://i.pravatar.cc/150?u=Gita"),
        MessageModel("Hana", "Lihat email ya", "https://i.pravatar.cc/150?u=Hana"),
        MessageModel("Irfan", "Oke noted", "https://i.pravatar.cc/150?u=Irfan"),
        MessageModel("Joko", "Sampai jumpa besok", "https://i.pravatar.cc/150?u=Joko")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityMessageFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }

        @Suppress("DEPRECATION")
        setHasOptionsMenu(true)

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    @Suppress("DEPRECATION")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    @Suppress("DEPRECATION")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}