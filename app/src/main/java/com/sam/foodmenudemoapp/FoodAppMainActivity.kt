package com.sam.foodmenudemoapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.tabs.TabLayout
import com.sam.foodmenudemoapp.databinding.ActivityScrollingBinding
import kotlinx.android.synthetic.main.content_scrolling.*

class FoodAppMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    var menuTabLayout: TabLayout? = null
    var menuViewPagerView: ViewPager2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.mainContent){
            menuTabLayout=packagetablayout
            menuViewPagerView=menuViewPager

        }
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title

        val numberOfScreens = resources.getStringArray(R.array.on_boarding_titles).size
        val viewPagerAdapter = ViewPagerFragmentAdapter(this, numberOfScreens)
        val menuViewPagerAdapter=ViewPagerFragmentAdapter(this,3)
        with(binding){
            onBoardingMarkerContainer.makeStatusBarTransparent()
            pager.adapter = viewPagerAdapter
            pager.registerOnPageChangeCallback(viewPageChangeCallback)
        }
        menuViewPagerView!!.adapter=menuViewPagerAdapter
        with(menuTabLayout!!){
            addTab(menuTabLayout!!.newTab().setText(R.string.pizza))
            addTab(menuTabLayout!!.newTab().setText(R.string.sushi))
            addTab(menuTabLayout!!.newTab().setText(R.string.drinks))
            tabGravity=TabLayout.GRAVITY_FILL
        }

        val menuTabAdapter = MenuTabAdapter(this, menuTabLayout!!.tabCount)
        menuViewPager!!.adapter = menuTabAdapter

        menuViewPager!!.registerOnPageChangeCallback(menuViewPagerChangeCallback)

        menuTabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                menuViewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
       // menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private var viewPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            updateCircleMarker(binding, position)
        }
    }

    private var menuViewPagerChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            menuTabLayout?.selectTab(menuTabLayout?.getTabAt(position))
        }
    }

    private fun updateCircleMarker(binding: ActivityScrollingBinding, position: Int) {
        when (position) {
            0 -> {
                binding.onBoardingInitialCircle.background = getDrawable(R.drawable.bg_green_circle)
                binding.onBoardingMiddleCircle.background = getDrawable(R.drawable.bg_gray_circle)
                binding.onBoardingLastCircle.background = getDrawable(R.drawable.bg_gray_circle)
            }
            1 -> {
                binding.onBoardingInitialCircle.background = getDrawable(R.drawable.bg_gray_circle)
                binding.onBoardingMiddleCircle.background = getDrawable(R.drawable.bg_green_circle)
                binding.onBoardingLastCircle.background = getDrawable(R.drawable.bg_gray_circle)
            }
            2 -> {
                binding.onBoardingInitialCircle.background = getDrawable(R.drawable.bg_gray_circle)
                binding.onBoardingMiddleCircle.background = getDrawable(R.drawable.bg_gray_circle)
                binding.onBoardingLastCircle.background = getDrawable(R.drawable.bg_green_circle)
            }
        }
    }

    override fun onDestroy() {
        binding.pager.unregisterOnPageChangeCallback(viewPageChangeCallback)
        super.onDestroy()
    }

    private fun View.makeStatusBarTransparent() {
        this.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }
}