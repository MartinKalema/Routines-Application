package com.example.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private var todos: List<Todo>,
    private val listener: OnItemClickListener
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.routines_list, parent, false)
       return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.display_text1).text = todos[position].routineName
        }.setOnClickListener {
            listener.onItemClick(position)
        }

    }

}

interface OnItemClickListener{
    fun onItemClick(position: Int)
}