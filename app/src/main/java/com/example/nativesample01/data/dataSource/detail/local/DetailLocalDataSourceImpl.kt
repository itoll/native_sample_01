package com.example.nativesample01.data.dataSource.detail.local

import com.example.nativesample01.data.util.database.TodoDao
import com.example.nativesample01.data.util.database.TodoEntity
import javax.inject.Inject

class DetailLocalDataSourceImpl @Inject constructor(
    private val dao: TodoDao
) : DetailLocalDataSource {
    override suspend fun fetchTodoUsingId(id: Long): TodoEntity = dao.getItemUsingId(id)

    override suspend fun insertTodo(todoEntity: TodoEntity) = dao.insertTodo(todoEntity)

    override suspend fun updateTodo(todoEntity: TodoEntity) = dao.updateTodo(todoEntity)

    override suspend fun deleteTodo(todoEntity: TodoEntity) = dao.deleteTodo(todoEntity)
}