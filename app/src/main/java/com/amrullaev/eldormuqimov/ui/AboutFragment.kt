package com.amrullaev.eldormuqimov.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.amrullaev.eldormuqimov.R
import com.amrullaev.eldormuqimov.databinding.FragmentAboutBinding
import com.amrullaev.eldormuqimov.databinding.FragmentHomeBinding
import com.amrullaev.eldormuqimov.databinding.ItemDialogBinding


class AboutFragment : Fragment() {
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(layoutInflater)
        val alertDialog = AlertDialog.Builder(binding.root.context, R.style.SheetDialog)
        val itemDialog = ItemDialogBinding.inflate(layoutInflater)
        alertDialog.setView(itemDialog.root)
        alertDialog.show()
        return binding.root
    }

}