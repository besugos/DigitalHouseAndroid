package com.besugos.aula39extodo.todo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula39extodo.R
import com.besugos.aula39extodo.todo.entity.TaskEntity

class TaskAdapter(private val tasks: List<TaskEntity>): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.TaskViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.task_list_item, parent, false)

        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskAdapter.TaskViewHolder, position: Int) {

        val task = tasks[position]
        holder.bind((task))
    }

    override fun getItemCount() = tasks.size

    class TaskViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        private val txtTask = view.findViewById<TextView>(R.id.txtTaskName)

        fun bind(task: TaskEntity) {
            txtTask.text = task.task
        }
    }
}