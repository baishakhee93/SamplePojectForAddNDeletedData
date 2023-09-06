package com.baishakhee.samplepoject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baishakhee.samplepoject.R
import com.baishakhee.samplepoject.model.TaskModel

class TaskAdapter(private val context: Context, private val taskList: MutableList<TaskModel>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    // ViewHolder class to hold the view components for each item in the RecyclerView
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskIdTextView: TextView = itemView.findViewById(R.id.taskIdTextView)
        val taskNameTextView: TextView = itemView.findViewById(R.id.taskNameTextView)
        val taskDescriptionTextView: TextView = itemView.findViewById(R.id.taskDescriptionTextView)
        val taskDateTextView: TextView = itemView.findViewById(R.id.taskDateTextView)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.task_item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = taskList[position]
        holder.taskIdTextView.text = task.taskId
        holder.taskNameTextView.text = task.taskName
        holder.taskDescriptionTextView.text = task.taskDescription
        holder.taskDateTextView.text = task.taskDate


        // Implement the delete button click listener
        holder.deleteButton.setOnClickListener {
            // Remove the item from the list
            taskList.removeAt(position)
            // Notify the adapter of the item removal
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}
