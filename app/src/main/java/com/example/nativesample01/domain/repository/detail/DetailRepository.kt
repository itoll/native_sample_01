package com.example.nativesample01.domain.repository.detail

import com.example.nativesample01.data.util.database.model.TodoModel

interface DetailRepository {
    suspend fun fetchTodoUsingId(id:Long):TodoModel

    suspend fun insertTodo(todoModel: TodoModel)

    suspend fun updateTodo(todoModel: TodoModel)

    suspend fun deleteTodo(todoModel: TodoModel)
}