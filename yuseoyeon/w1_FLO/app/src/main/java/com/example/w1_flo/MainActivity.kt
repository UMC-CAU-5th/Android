package com.example.w1_flo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.w1_flo.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private  lateinit var binding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var song=Song()
    private var gson: Gson =Gson()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding.bottomNav.setupWithNavController(navHostFragment.navController)



        clickMusicBar()
        setResultSong()


    }
    private fun clickMusicBar(){
        //val song=Song(binding.playBarTitle.text.toString(), binding.playBarArtist.text.toString(),0,60,false,"music_lilac")
        binding.playBar.setOnClickListener{
            val intent=Intent(this,SongActivity::class.java)
            intent.putExtra("title",song.title)
            intent.putExtra("artist",song.artist)
            intent.putExtra("second",song.second)
            intent.putExtra("playTime",song.playTime)
            intent.putExtra("isPlaying",song.isPlaying)
            intent.putExtra("music",song.music)
            resultLauncher.launch(intent)
        }
    }
    private fun setResultSong(){
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == Activity.RESULT_OK){
                Toast.makeText(this.applicationContext,result.data?.getStringExtra("album_songTohome"),Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setMiniPlayer(song:Song){
        binding.playBarTitle.text=song.title
        binding.playBarArtist.text=song.artist
        binding.mainMiniplayerProgressSb.progress=(song.second*100000)/song.playTime
    }
    override fun onStart() {
        super.onStart()
        val sharedPreferences=getSharedPreferences("song", MODE_PRIVATE)
        val songJson=sharedPreferences.getString("songData",null)

        song=if(songJson==null){
            Song("라일락","아이유(iu)",0,60,false,"music_lilac")
        }
        else
            gson.fromJson(songJson,Song::class.java)

        setMiniPlayer(song)
    }

}