package com.example.demo

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import com.example.demo.databinding.ActivitySelectEventBinding


class SelectEvent : AppCompatActivity() {

    private lateinit var binding: ActivitySelectEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySelectEventBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backArrow.setOnClickListener {
            val backToCreateRoutine = Intent(this, CreateRoutine::class.java)
            startActivity(backToCreateRoutine)
        }

        binding.timeTextview.setOnClickListener {

            val intent = Intent(this, CreateRoutine::class.java)
            intent.putExtra("TIMEPICKER", "Open TimePickerDialog")
            startActivity(intent)
        }


        //making text bold
        val boldSpan = StyleSpan(Typeface.BOLD)
        //first text view
        val firstText = binding.timeTextview.text.toString()
        val spannable1 = SpannableString(firstText)
        spannable1.setSpan(boldSpan, 12, 16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.timeTextview.text = spannable1

        //second textView
        val secondText = binding.secondTextview.text.toString()
        val spannable2 = SpannableString(secondText)
        spannable2.setSpan(boldSpan, 15, 23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.secondTextview.text = spannable2

        //third textView
        val thirdText = binding.thirdTextview.text.toString()
        val spannable3 = SpannableString(thirdText)
        spannable3.setSpan(boldSpan, 16, 24, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.thirdTextview.text = spannable3

        //fourth textView
        val fourthText = binding.fourthTextview.text.toString()
        val spannable4 = SpannableString(fourthText)
        spannable4.setSpan(StyleSpan(Typeface.BOLD), 5, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable4.setSpan(StyleSpan(Typeface.BOLD), 34, 42, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.fourthTextview.text = spannable4

        //fifth textview
        val fifthText = binding.fifthTextview.text.toString()
        val spannable5 = SpannableString(fifthText)
        spannable5.setSpan(StyleSpan(Typeface.BOLD), 5, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable5.setSpan(StyleSpan(Typeface.BOLD), 33, 41, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.fifthTextview.text = spannable5

        //sixth textview
        val sixthText = binding.sixthTextview.text.toString()
        val spannable6 = SpannableString(sixthText)
        spannable6.setSpan(StyleSpan(Typeface.BOLD), 5, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable6.setSpan(StyleSpan(Typeface.BOLD), 33, 41, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.sixthTextview.text = spannable6

        //seventh textview
        val seventhText = binding.seventhTextview.text.toString()
        val spannable7 = SpannableString(seventhText)
        spannable7.setSpan(StyleSpan(Typeface.BOLD), 5, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable7.setSpan(StyleSpan(Typeface.BOLD), 32, 40, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.seventhTextview.text = spannable7

    }
}