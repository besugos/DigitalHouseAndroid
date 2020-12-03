package com.besugos.aula39extodo.todo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.besugos.aula39extodo.todo.entity.TaskEntity

@Dao
interface TaskDao {

    @Insert
    suspend fun addTask(task: TaskEntity)

    @Query ("SELECT * FROM Task")
    suspend fun getTasks(): List<TaskEntity>
}