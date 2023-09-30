package com.example.w1_flo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.w1_flo.databinding.FragmentHomeBinding

private lateinit var binding:FragmentHomeBinding

class homeFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)



        binding.todayAlbum1.setOnClickListener {
            var fragAlbum=albumFrag()
            var bundle=Bundle()
            val song=Song(binding.todayAlbum1Title.text.toString(), binding.todayAlbum1Artist.text.toString())
            bundle.putString("title_album",song.title)
            bundle.putString("artist_album",song.artist)
            fragAlbum.arguments=bundle
            Log.d("Song",song.title+song.artist)

            (context as MainActivity).supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView,fragAlbum,"album").commitAllowingStateLoss()
            //(context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,fragAlbum).commitAllowingStateLoss()
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}