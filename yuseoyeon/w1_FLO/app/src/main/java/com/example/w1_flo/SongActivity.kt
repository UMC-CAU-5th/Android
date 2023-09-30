package com.example.w1_flo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.w1_flo.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySongBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if(intent.hasExtra("title")&&intent.hasExtra("artist")){
            binding.songMusicTitleTv.text=intent.getStringExtra("title")
            binding.songSingerNameTv.text=intent.getStringExtra("artist")
        }
        binding.songDownIb.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            intent.putExtra("album_songTohome","IU 5th Album 'LILAC'")
            setResult(RESULT_OK,intent)
            finish()
        }


    }
}