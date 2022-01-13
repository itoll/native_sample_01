package com.example.nativesample01.data.dataSource.detail.local

import com.example.nativesample01.data.util.database.TodoEntity

interface DetailLocalDataSource {
    suspend fun fetchTodoUsingId(id:Long): TodoEntity

    suspend fun insertTodo(todoEntity: TodoEntity)

    suspend fun updateTodo(todoEntity: TodoEntity)

    suspend fun deleteTodo(todoEntity: TodoEntity)
}