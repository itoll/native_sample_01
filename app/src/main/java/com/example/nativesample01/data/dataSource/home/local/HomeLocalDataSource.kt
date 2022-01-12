package com.example.nativesample01.data.dataSource.home.local

import com.example.nativesample01.data.util.database.TodoEntity

interface HomeLocalDataSource {
    suspend fun fetchTodos():List<TodoEntity>
}