package com.example.nativesample01.domain.repository.home

import com.example.nativesample01.data.util.database.model.TodoModel

interface HomeRepository {
    suspend fun fetchTodos():List<TodoModel>
}