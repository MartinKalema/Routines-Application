package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.demo.databinding.ActivityThingSelectionBinding
import com.google.android.material.tabs.TabLayoutMediator

class ThingSelection : AppCompatActivity() {


    private lateinit var binding: ActivityThingSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityThingSelectionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position->
            when(position){
                0->{
                    tab.text="THINGS"
                }
                1->{
                    tab.text="SCENES"
                }
                2->{
                    tab.text="ROUTINES"
                }
            }
        }.attach()

        //Setting listener on select thing back button
        binding.thingSelectionBackButton.setOnClickListener {
            val backToCreateRoutine = Intent(this, CreateRoutine::class.java)
            startActivity(backToCreateRoutine)
        }







    }
}