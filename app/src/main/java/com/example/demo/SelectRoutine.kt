package com.example.demo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.databinding.ActivitySelectRoutineBinding

class SelectRoutine : AppCompatActivity(), OnItemClickListener {

    private lateinit var binding: ActivitySelectRoutineBinding
    //todolist
    private var todoList: MutableList<Todo> = mutableListOf()
    //newList
    private val adapter = TodoAdapter(todoList, this@SelectRoutine)
    //routines Database object
    private val dbHelper = DatabaseHelper(this@SelectRoutine)
    //favorites database object
    private val favoritesHelper = FavoritesDB(this@SelectRoutine)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySelectRoutineBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //all names
        val namesList = dbHelper.getAllNames()
        //bind recycler to adapter
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this@SelectRoutine)
        //Add each name to the todolist
        for(name in namesList){
            todoList.add(Todo(name))
            adapter.notifyItemInserted(todoList.size - 1)
        }

        binding.createRoutineBackButton.setOnClickListener {
            val backToMain = Intent(this@SelectRoutine, MainActivity::class.java)
            startActivity(backToMain)

        }

        binding.createRoutineButton.setOnClickListener {
            val moveToCreateRoutine = Intent(this@SelectRoutine, CreateRoutine::class.java)
            startActivity(moveToCreateRoutine)
        }

    }

    override fun onItemClick(position: Int) {

        val builder = AlertDialog.Builder(this@SelectRoutine)
            .setPositiveButton("OK"){_,_ ->
                val routineName = todoList[position].routineName
                
                Toast.makeText(this, "Successfully added to favorites", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("CANCEL"){_,_ ->

            }
            .setTitle("Add to favorites?")

       builder.show()

    }





}