package com.besugos.aula39extodo.todo.view
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula39extodo.R
import com.besugos.aula39extodo.db.AppDatabase
import com.besugos.aula39extodo.todo.entity.TaskEntity
import com.besugos.aula39extodo.todo.repository.TaskRepository
import com.besugos.aula39extodo.todo.viewmodel.TaskViewModel

class TaskListFragment : Fragment() {

    private lateinit var _viewModel: TaskViewModel
    private lateinit var _taskAdapter: TaskAdapter
    private var _tasks = mutableListOf<TaskEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etTask = view.findViewById<EditText>(R.id.etTaskName)
        val btnAdd = view.findViewById<Button>(R.id.btnAddTask)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvTaskList)
        val manager = LinearLayoutManager(this.context)
        _taskAdapter = TaskAdapter(_tasks)

        recyclerView.apply {
            layoutManager = manager
            adapter = _taskAdapter
        }

        _viewModel = ViewModelProvider(this,
            TaskViewModel.TaskViewModelFactory(
                TaskRepository(AppDatabase.getDatabase(view.context).taskDao())
            )
        ).get(TaskViewModel::class.java)

        _viewModel.getTasks().observe(viewLifecycleOwner, {
            _tasks.clear()
            _tasks.addAll(it)
            _taskAdapter.notifyDataSetChanged()
        })

        btnAdd.setOnClickListener {
            if (etTask.text.isNotBlank()) {
                val task = TaskEntity(0, etTask.text.toString())
                etTask.text.clear()
                _viewModel.addTask(task).observe(viewLifecycleOwner, {
                    if (it) {
                        _tasks.add(task)
                        _taskAdapter.notifyDataSetChanged()
                    }
                })
            }
        }
    }
}