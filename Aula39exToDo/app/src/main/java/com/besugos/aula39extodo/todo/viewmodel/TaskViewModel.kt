package com.besugos.aula39extodo.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.besugos.aula39extodo.todo.entity.TaskEntity
import com.besugos.aula39extodo.todo.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlin.math.absoluteValue

class TaskViewModel(private val repository: TaskRepository): ViewModel() {

    fun addTask(task: TaskEntity) = liveData(Dispatchers.IO) {
        repository.addTask(task)
        emit(true)
        //emit(task)
    }

    fun getTasks() = liveData(Dispatchers.IO) {
        val tasks = repository.getTasks()
        emit(tasks)
    }

    class TaskViewModelFactory(private val repository: TaskRepository):
            ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TaskViewModel(repository) as T
        }
    }
}