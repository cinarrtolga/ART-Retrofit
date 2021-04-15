package com.example.retrofitarticlesample.api

import com.example.retrofitarticlesample.domain.TodoModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface RetrofitSampleService {
    @GET("todos")
    suspend fun getAllTodos(): List<TodoModel>
}

object RetrofitApi {
    val retrofitService: RetrofitSampleService by lazy {
        retrofit.create(RetrofitSampleService::class.java)
    }
}