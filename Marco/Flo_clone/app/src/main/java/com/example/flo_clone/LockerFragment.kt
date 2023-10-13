package com.example.flo_clone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.flo_clone.databinding.FragmentLockerBinding
import com.google.android.material.tabs.TabLayoutMediator

class LockerFragment : Fragment() {

    lateinit var binding : FragmentLockerBinding

    private val information = arrayListOf("저장한 곡", "응악파일")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLockerBinding.inflate(inflater,container,false)

        val lockerAdapter = LockerVPAdapter(this)
        binding.lockerListVp.adapter = lockerAdapter
        TabLayoutMediator(binding.lockerListTb, binding.lockerListVp){
            tab, position ->
            tab.text = information[position]
        }.attach()

        return binding.root
    }
}