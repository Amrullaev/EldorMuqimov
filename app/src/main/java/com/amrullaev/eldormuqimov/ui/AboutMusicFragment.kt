package com.amrullaev.eldormuqimov.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amrullaev.eldormuqimov.databinding.FragmentAboutMusicBinding


class AboutMusicFragment : Fragment() {
    private var _binding: FragmentAboutMusicBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutMusicBinding.inflate(layoutInflater)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.infoCv2.setOnClickListener { open("https://www.youtube.com/@eldormuqimov9341") }
        binding.infoCv6.setOnClickListener { open("https://t.me/+5jfvDxEDnJFhNTcy") }
        binding.infoCv4.setOnClickListener { open("https://www.instagram.com/eldor__muqimov/") }
        binding.infoCv8.setOnClickListener {
            val phone = "+998936968890"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)

        }
    }

    private fun open(uri: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
        }
    }


}