package com.example.atc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        var viewPager2:ViewPager2 = findViewById(R.id.view_pager2)
        var tabLayout:TabLayout = findViewById(R.id.tab_layout)
        var adapter = MyFragmentAdapter(supportFragmentManager,lifecycle)
        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager2){tab,position ->
            when(position){
                0 -> tab.text = "Chat"
                1 -> tab.text = "Status"
                else -> tab.text = "Call"
            }
        }.attach()

    }
}