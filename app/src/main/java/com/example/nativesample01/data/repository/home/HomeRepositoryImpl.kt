package com.example.nativesample01.data.repository.home

import com.example.nativesample01.data.dataSource.home.local.HomeLocalDataSource
import com.example.nativesample01.data.dataSource.home.local.model.TodoModel
import com.example.nativesample01.data.util.mapper.TodoMapper
import com.example.nativesample01.domain.repository.home.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val dataSource: HomeLocalDataSource,
    private val todoMapper: TodoMapper
) : HomeRepository {
    override suspend fun fetchTodos(): List<TodoModel> {
        return dataSource
            .fetchTodos()
            .map {
                todoMapper.toModel(it)
            }
    }
}