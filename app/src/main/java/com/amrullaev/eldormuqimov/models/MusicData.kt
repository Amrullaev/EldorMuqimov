package com.amrullaev.eldormuqimov.models

data class MusicData(
    var id: Int,
    val audioName: String = "",
    val audioMP3: String,
    val audioImage: Int,
    var currentIndex: Int
) : java.io.Serializable
