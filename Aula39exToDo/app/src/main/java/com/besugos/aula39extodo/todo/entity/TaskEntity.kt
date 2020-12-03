package com.besugos.aula39extodo.todo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class TaskEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo
    var task: String
)