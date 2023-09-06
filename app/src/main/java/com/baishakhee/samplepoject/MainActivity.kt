package com.baishakhee.samplepoject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.baishakhee.samplepoject.adapter.TaskAdapter
import com.baishakhee.samplepoject.databinding.ActivityMainBinding
import com.baishakhee.samplepoject.model.TaskModel
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TaskAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = TaskAdapter(this,taskList) // Pass your taskList to the adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        binding.addTaskButton.setOnClickListener {
            showBottomSheetDialog();

        }
    }

    companion object {
        private val taskList = mutableListOf<TaskModel>()
        @SuppressLint("StaticFieldLeak")
        private lateinit var taskIdEditText: EditText
        @SuppressLint("StaticFieldLeak")
        private lateinit var taskNameEditText: EditText
        @SuppressLint("StaticFieldLeak")
        private lateinit var taskDateEditText: EditText
        @SuppressLint("StaticFieldLeak")
        private lateinit var taskDescriptionEditText: EditText
        @SuppressLint("StaticFieldLeak")
        private lateinit var submitButton: Button

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottomSheetView = layoutInflater.inflate(R.layout.addtask, null)
        bottomSheetDialog.setContentView(bottomSheetView)

        bottomSheetDialog.setContentView(bottomSheetView)

        // Initialize views
        taskIdEditText = bottomSheetView.findViewById(R.id.taskIdEditText)
        taskNameEditText = bottomSheetView.findViewById(R.id.taskNameEditText)
        taskDateEditText = bottomSheetView.findViewById(R.id.taskDateEditText)
        taskDescriptionEditText = bottomSheetView.findViewById(R.id.taskDescriptionEditText)
        submitButton = bottomSheetView.findViewById(R.id.submitButton)

        bottomSheetDialog.show()

        submitButton.setOnClickListener {

            val taskId = "Task ID : "+taskIdEditText.text.toString()
            val taskName = "Task Name : "+taskNameEditText.text.toString()
            val taskDate = "Task Date : "+taskDateEditText.text.toString()
            val taskDescription = "Task Description : "+taskDescriptionEditText.text.toString()

            // Create a Task object and add it to the list
            val task = TaskModel(taskId, taskName, taskDate, taskDescription)
            taskList.add(task)
            adapter.notifyDataSetChanged()

            bottomSheetDialog.dismiss()
        }


        bottomSheetDialog.show()
    }
}