package com.example.retrofitarticlesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.getTodoList()

        viewModel.todoList.observe(this, Observer {
            if(it.isNotEmpty()) {
                Log.i("information", "working")
            }
        })

        setContentView(R.layout.activity_main)
    }
}