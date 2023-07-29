package com.example.demo

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.logging.Logger.global

class FavoritesFragment : Fragment() {


    //todolist
    // mutableListOf() creates an empty mutable list.
    private val todoList: MutableList<Todo> = mutableListOf()
    //Database Helper
    private val favoritesHelper = FavoritesDB(requireContext())
    //Obtaining favorites from the database
    private val namesList = favoritesHelper.getAllNames()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_favorites, container, false)


        //accessing button
        val floatingButton = rootView.findViewById<FloatingActionButton>(R.id.floatingActionBtn2)
        //Setting on click listener
        floatingButton.setOnClickListener {
            /* The Intent constructor  requires the reference to the current fragments parent activity and also a
            reference to the target activity's class object.
            Kotlin runs on a Java Virtual Machine and uses Java class objects to refer to classes. All class objects are implemented in java.
            */
            val moveToSelectRoutine = Intent(activity, SelectRoutine::class.java)
            startActivity(moveToSelectRoutine)
        }

        //adapter
        val adapter = TodoAdapter(todoList, object: OnItemClickListener{
            override fun onItemClick(position: Int) {
                val builder = AlertDialog.Builder(requireContext())
                    .setTitle("Remove from Favorites?")
                    .setPositiveButton("OK"){_,_ ->
                        val routineName = todoList[position].routineName
                        todoList.removeAt(position)
                        if(favoritesHelper.deleteRecord(routineName)){
                            Toast.makeText(requireContext(), "Removed from Favorites", Toast.LENGTH_LONG).show()
                        }
                    }
                    .setNegativeButton("CANCEL"){_,_->

                    }
                builder.show()
            }
        })



        //fetching recycler
        val recycler =  rootView.findViewById<RecyclerView>(R.id.favoritesRecycler)
        //changing its adapter
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        //Add each name in database to the todolist
        for(name in namesList){
            todoList.add(Todo(name))
            adapter.notifyItemInserted(todoList.size - 1)
        }

        return rootView
    }

}