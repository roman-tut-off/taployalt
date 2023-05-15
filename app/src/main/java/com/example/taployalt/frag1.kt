package com.example.taployalt

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class frag1 : Fragment() {

    var player = false
    var trek = 0
    var temp = 0

    private val listMusic = listOf(
        R.raw.daxak,
        R.raw.baik,
        R.raw.tp,
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        var sPref: SharedPreferences? = null
        sPref = requireContext().getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        trek = sPref?.getInt("trek", 0)!!
        val editor = sPref?.edit()
        val view = inflater.inflate(R.layout.fragment_frag1, container, false)
        val bmusic = view.findViewById<Button>(R.id.batonmusic)
        val textTrack = view.findViewById<TextView>(R.id.CountTrack_TW)
        textTrack.text = "Играет трек номер ${trek}"


        var mediaPlayer = MediaPlayer.create(context, listMusic[trek])

        bmusic.setOnClickListener{
            if (!player) {
                mediaPlayer.start()
                player = true

                textTrack.text = "Играет трек номер ${trek}"
                editor?.putInt("trek", trek)
                editor?.apply()

                trek += 1
                if (trek > 2) trek = 0
            } else {
                mediaPlayer.stop()
                player = false
                mediaPlayer = MediaPlayer.create(context, listMusic[trek])
            }
        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = frag1()

    }
}