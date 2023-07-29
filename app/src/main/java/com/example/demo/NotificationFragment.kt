package com.example.demo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


class NotificationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_notification, container, false)

        //listener on notification icon
        binding.findViewById<ImageView>(R.id.notification_icon).setOnClickListener {
            binding.findViewById<LinearLayout>(R.id.notification_container).visibility = View.GONE
            binding.findViewById<TextView>(R.id.invisible_text).visibility = View.VISIBLE
        }

        //listener on textview
        binding.findViewById<TextView>(R.id.invisible_text).setOnClickListener {
            val moveToCreateRoutine = Intent(activity, CreateRoutine::class.java)
            moveToCreateRoutine.putExtra("Alert_Box", "Instantiate AlertDialog")
            startActivity(moveToCreateRoutine)

        }
        return binding
    }


}