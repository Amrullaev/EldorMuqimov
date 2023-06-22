package com.amrullaev.eldormuqimov.ui


import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.amrullaev.eldormuqimov.R
import com.amrullaev.eldormuqimov.databinding.FragmentMusicBinding
import com.amrullaev.eldormuqimov.models.MusicData
import com.amrullaev.eldormuqimov.utils.Constanta


class MusicFragment : Fragment() {
    private var _binding: FragmentMusicBinding? = null
    private val binding get() = requireNotNull(_binding)
    private lateinit var runnable: Runnable
    private var handler = Handler()
    private lateinit var songs: ArrayList<MusicData>
    private var mediaPlayer: MediaPlayer = MediaPlayer()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMusicBinding.inflate(layoutInflater)


        songs = ArrayList()
        val animationSimple = AnimationUtils.loadAnimation(
            requireContext(),
            R.anim.simple_anim
        )


        var music = requireArguments().getInt("audio")
        val musicName = arguments?.get("music") as MusicData



        songs = Constanta.musicList
        Log.d("TAG", "onCreateView: $songs")

        binding.musicName.text = musicName.audioName
        binding.musicImage.setImageResource(musicName.audioImage)

        mediaPlayer = MediaPlayer.create(requireContext(), music)

        binding.seekbar.progress = 0
        binding.seekbar.max = mediaPlayer.duration

        binding.playBtn.setOnClickListener {
            if (!mediaPlayer.isPlaying) {

                mediaPlayer.start()
                binding.playBtn.setImageResource(R.drawable.pause_142)
            } else {
                mediaPlayer.pause()
                binding.playBtn.setImageResource(R.drawable.play_btn)
            }
            binding.cvImage.startAnimation(animationSimple)
        }

        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if (changed) {
                    mediaPlayer.seekTo(pos)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        runnable = Runnable {
            binding.seekbar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)

        mediaPlayer.setOnCompletionListener {
            binding.playBtn.setImageResource(R.drawable.play_btn)
            binding.seekbar.progress = 0
        }


        binding.nextBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Hozircha ishlamayapti", Toast.LENGTH_SHORT).show()
        }

        binding.backBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Hozircha ishlamayapti", Toast.LENGTH_SHORT).show()
        }




        return binding.root

    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.isLooping = false
        mediaPlayer.stop()
        mediaPlayer.release()
        handler.removeCallbacks(runnable)
        _binding = null
    }
}
