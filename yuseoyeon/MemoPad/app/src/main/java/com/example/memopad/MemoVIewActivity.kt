package com.example.memopad

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.memopad.databinding.ActivityMemoViewBinding

class MemoVIewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemoViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}