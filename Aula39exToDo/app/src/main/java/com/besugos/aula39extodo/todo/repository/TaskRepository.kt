package com.besugos.aula39extodo.todo.repository

import com.besugos.aula39extodo.todo.dao.TaskDao
import com.besugos.aula39extodo.todo.entity.TaskEntity

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun addTask(task: TaskEntity) = taskDao.addTask(task)
    suspend fun getTasks() = taskDao.getTasks()
}