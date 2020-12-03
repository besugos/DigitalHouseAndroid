package com.besugos.aula39extodo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.besugos.aula39extodo.todo.view.TaskListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, TaskListFragment())
            .commit()
    }
}