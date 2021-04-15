package com.example.retrofitarticlesample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitarticlesample.api.RetrofitApi
import com.example.retrofitarticlesample.domain.TodoModel
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    var todoList = MutableLiveData<List<TodoModel>>()

    fun getTodoList() {
        viewModelScope.launch {
            todoList.value = RetrofitApi.retrofitService.getAllTodos()
        }
    }
}