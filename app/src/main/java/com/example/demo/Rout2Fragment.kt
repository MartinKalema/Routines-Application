package com.example.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Rout2Fragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
         val rootView = inflater.inflate(R.layout.fragment_rout2, container, false)

        //Database Helper
        val dbHelper = DatabaseHelper(requireContext())
        val namesList = dbHelper.getAllNames()

        //todolist
        val todoList: MutableList<Todo> = mutableListOf()

        val adapter = TodoAdapter(todoList, object : OnItemClickListener{
            override fun onItemClick(position: Int) {

            }
        })
        val recycler =  rootView.findViewById<RecyclerView>(R.id.recycler2)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        //Add each name to the todolist
        for(name in namesList){
            todoList.add(Todo(name))
            adapter.notifyItemInserted(todoList.size - 1)
        }
        return rootView
    }


}