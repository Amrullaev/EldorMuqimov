package com.amrullaev.eldormuqimov.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.amrullaev.eldormuqimov.R
import com.amrullaev.eldormuqimov.adapters.MusicAdapter
import com.amrullaev.eldormuqimov.databinding.FragmentHomeBinding
import com.amrullaev.eldormuqimov.models.MusicData
import com.amrullaev.eldormuqimov.utils.Constanta
import java.text.FieldPosition

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = requireNotNull(_binding)
    var fabVisible = false

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        fabVisible = false

        val musicAdapter = MusicAdapter(audioLoadList(), object : MusicAdapter.OnclickListener {
            override fun onClick(musicData: MusicData, position: Int) {
                val bundle = Bundle()
                bundle.putInt("audio", position)
                bundle.putSerializable("music", musicData)
                findNavController().navigate(R.id.musicFragment, bundle)
            }

        })
        binding.rv.adapter = musicAdapter
        Constanta.musicList = audioLoadList()

        binding.idFABAdd.setOnClickListener {
            // on below line we are checking
            // fab visible variable.
            if (!fabVisible) {

                // if its false we are displaying home fab
                // and settings fab by changing their
                // visibility to visible.
                binding.idFABHome.show()
                binding.idFABSettings.show()

                // on below line we are setting
                // their visibility to visible.
                binding.idFABHome.visibility = View.VISIBLE
                binding.idFABSettings.visibility = View.VISIBLE

                // on below line we are checking image icon of add fab
                binding.idFABAdd.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_close_24))

                // on below line we are changing
                // fab visible to true
                fabVisible = true
            } else {

                // if the condition is true then we
                // are hiding home and settings fab
                binding.idFABHome.hide()
                binding.idFABSettings.hide()

                // on below line we are changing the
                // visibility of home and settings fab
                binding.idFABHome.visibility = View.GONE
                binding.idFABSettings.visibility = View.GONE

                // on below line we are changing image source for add fab
                binding.idFABAdd.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_add_24))

                // on below line we are changing
                // fab visible to false.
                fabVisible = false
            }
        }

        // on below line we are adding
        // click listener for our home fab
        binding.idFABHome.setOnClickListener {

            findNavController().navigate(R.id.aboutFragment)
        }

        // on below line we are adding on
        // click listener for settings fab
        binding.idFABSettings.setOnClickListener {
            findNavController().navigate(R.id.aboutMusicFragment)
        }


        return binding.root
    }


    private fun audioLoadList(): ArrayList<MusicData> {
        val list = ArrayList<MusicData>()
        list.add(
            MusicData(
                R.raw.chapandozi,
                "Chapandozi va Savti Suvora",
                "chapandozi.mp3",
                R.drawable.eldor7, 1
            )
        )
        list.add(
            MusicData(
                R.raw.dema, "Dema", "dema.mp3",
                R.drawable.eldor8, 2
            )
        )
        list.add(
            MusicData(
                R.raw.gamzasin, "G'amzasin", "gamzasin.mp3",
                R.drawable.eldor9, 3
            )
        )
        list.add(
            MusicData(
                R.raw.nafoyda, "Na foyda", "nafoyda.mp3",
                R.drawable.eldor10, 4
            )
        )
        list.add(
            MusicData(
                R.raw.omonat, "Omonat", "omonat.mp3",
                R.drawable.eldor11, 5
            )
        )
        list.add(
            MusicData(
                R.raw.otajonim_asra_xudoyim,
                "Otajonim asra xudoyim",
                "otajonim_asra_xudoyim.mp3",
                R.drawable.eldor8, 6
            )
        )
        list.add(
            MusicData(
                R.raw.qalandarim, "Qalandarim", "qalandarim.mp3",
                R.drawable.eldor11, 7
            )
        )
        list.add(
            MusicData(
                R.raw.unutmanglar, "Unutmanglar", "unutmanglar.mp3",
                R.drawable.eldor7, 8
            )
        )
        list.add(
            MusicData(
                R.raw.yiqilganni_tepma_dostim,
                "Yiqilganni tepma do'stim",
                "yiqilganni_tepma_dostim.mp3",
                R.drawable.eldor9, 9
            )
        )
        list.add(
            MusicData(
                R.raw.topmassan,
                "Topmassan",
                "topmassan.mp3",
                R.drawable.eldor10, 10
            )
        )

        return list
    }


}