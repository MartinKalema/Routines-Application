package com.example.demo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FavFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment and store reference to root view.
        val rootView = inflater.inflate(R.layout.fragment_fav, container, false)
        //Using root view to access child view
        val floatingButton = rootView.findViewById<FloatingActionButton>(R.id.floatingActionBtn1)
        //Setting on click listener
        floatingButton.setOnClickListener {
            /* The Intent constructor  requires the reference to the current fragments parent activity and also a
            reference to the target activity's class object.
            Kotlin runs on a Java Virtual Machine and uses Java class objects to refer to classes. All class objects are implemented in java.
            */
            val moveToSelectRoutine = Intent(activity, SelectRoutine::class.java)
            startActivity(moveToSelectRoutine)
        }

        return rootView
    }


}




/*A class object is an object that represents a class at runtime. It contains information about the
class such as its name, methods and fields and it can be used to create new instances of the class.
Intent() requires a class object for the target activity
 */