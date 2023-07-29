package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        binding.checkbox1.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){

            } else{

            }
        }

        binding.radioButton1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){

            } else {

            }
        }
    }
}