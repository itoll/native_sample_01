package com.example.nativesample01.data.repository.detail

import com.example.nativesample01.data.dataSource.detail.local.DetailLocalDataSource
import com.example.nativesample01.data.util.database.model.TodoModel
import com.example.nativesample01.data.util.mapper.TodoMapper
import com.example.nativesample01.domain.repository.detail.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val detailLocalDataSource: DetailLocalDataSource,
    private val todoMapper: TodoMapper
) : DetailRepository {
    override suspend fun fetchTodoUsingId(id: Long): TodoModel {
        val todoEntity = detailLocalDataSource.fetchTodoUsingId(id)
        return todoMapper.toModel(todoEntity)
    }

    override suspend fun insertTodo(todoModel: TodoModel) {
        val todoEntity = todoMapper.toEntity(todoModel)
        return detailLocalDataSource.insertTodo(todoEntity)
    }

    override suspend fun updateTodo(todoModel: TodoModel) {
        val todoEntity = todoMapper.toEntity(todoModel)
        return detailLocalDataSource.updateTodo(todoEntity)
    }

    override suspend fun deleteTodo(todoModel: TodoModel) {
        val todoEntity = todoMapper.toEntity(todoModel)
        return detailLocalDataSource.deleteTodo(todoEntity)
    }
}