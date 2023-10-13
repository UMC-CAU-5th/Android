package com.example.flo_clone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo_clone.databinding.FragmentBackpannelBinding

class BackpannelFragment(val imgRes : Int) : Fragment() {

    lateinit var binding : FragmentBackpannelBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBackpannelBinding.inflate(inflater,container,false)

        binding.homePannelBackgroundIv.setImageResource(imgRes)
        return binding.root
    }
}