package com.example.nativesample01.domain.repository.home

import com.example.nativesample01.data.dataSource.home.local.model.TodoModel

interface HomeRepository {
    suspend fun fetchTodos():List<TodoModel>
}