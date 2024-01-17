package com.example.atc

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyFragmentAdapter (frgMng: FragmentManager, lifecycle:Lifecycle):FragmentStateAdapter(frgMng,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> {return ChatFragment()}
            1 -> {return StatusFragment()}
            else -> {return CallFragment()}
        }

    }

}