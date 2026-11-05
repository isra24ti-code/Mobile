package com.example.p3isra.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.example.p3isra.R
import com.example.p3isra.databinding.ItemMessageBinding

class MessageAdapter(
    context: Context,
    private val messageList: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messageList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding = ItemMessageBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        val view = binding.root

        val data = messageList[position]

        // Binding data teks & gambar
        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText

        Glide.with(context)
            .load(data.avatarUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.avatarImg)

        // Terapkan onClick listener di dalam Adapter menggunakan Snackbar
        view.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName}: ${data.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return view
    }
}