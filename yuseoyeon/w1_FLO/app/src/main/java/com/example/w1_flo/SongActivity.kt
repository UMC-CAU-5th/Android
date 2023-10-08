package com.example.w1_flo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true)
        }

        var repeatOn:Boolean=false
        binding.songRepeatIv.setOnClickListener {
            if(!repeatOn){
                binding.songRepeatIv.setColorFilter(Color.parseColor("#3f3fff"))
                repeatOn=true
            }
            else{
                binding.songRepeatIv.clearColorFilter()
                repeatOn=false
            }
        }
        var randomOn:Boolean=false
        binding.songRandomIv.setOnClickListener {
            if(!randomOn){
                binding.songRandomIv.setColorFilter(Color.parseColor("#3f3fff"))
                randomOn=true
            }
            else{
                binding.songRandomIv.clearColorFilter()
                randomOn=false
            }
        }


    }

    fun setPlayerStatus(isPlaying:Boolean){
        if(isPlaying){
            binding.songMiniplayerIv.visibility= View.VISIBLE
            binding.songPauseIv.visibility=View.GONE

        }
        else{
            binding.songMiniplayerIv.visibility= View.GONE
            binding.songPauseIv.visibility=View.VISIBLE
        }
    }
}