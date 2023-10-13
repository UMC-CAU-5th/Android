package com.example.flo_clone

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.flo_clone.databinding.FragmentHomeBinding
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    private val timer = Timer()
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.homeAlbumImgIv1.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm,AlbumFragment()).commitAllowingStateLoss()
        }

        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val backpannelAdapter = BackpannelVPAdapter(this)
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        binding.homePannelBackgroundVp.adapter = backpannelAdapter
        binding.homePannelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        // Indicator에 viewPager 설정
        binding.homePannelIndicator.setViewPager(binding.homePannelBackgroundVp)

        val topBannerAdapter = BackpannelVPAdapter(this)
        startAutoSlide(topBannerAdapter)

        return binding.root
    }

    private fun startAutoSlide(adapter: BackpannelVPAdapter){
        timer.scheduleAtFixedRate(3000, 3000) {
            handler.post{
                val nextItem = binding.homePannelBackgroundVp.currentItem + 1

                if(nextItem == 7)
                    binding.homePannelBackgroundVp.currentItem = 0
                else
                    binding.homePannelBackgroundVp.currentItem = nextItem
            }
        }
    }
}