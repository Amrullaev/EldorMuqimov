package com.amrullaev.eldormuqimov.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amrullaev.eldormuqimov.databinding.ItemMusicBinding
import com.amrullaev.eldormuqimov.models.MusicData

class MusicAdapter(
    private val list: List<MusicData>,
    private val listener: OnclickListener
) :
    RecyclerView.Adapter<MusicAdapter.VH>() {

    inner class VH(private val itemMusicBinding: ItemMusicBinding) :
        RecyclerView.ViewHolder(itemMusicBinding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(musicData: MusicData,position: Int) {
            itemMusicBinding.musicName.text = musicData.audioName
            itemMusicBinding.musicImage.setImageResource(musicData.audioImage)
            itemMusicBinding.root.setOnClickListener {
                listener.onClick(musicData,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int = list.size

    interface OnclickListener {
        fun onClick(musicData: MusicData,position: Int)
    }
}