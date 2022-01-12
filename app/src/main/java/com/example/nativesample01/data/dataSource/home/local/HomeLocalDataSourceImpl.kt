package com.example.nativesample01.data.dataSource.home.local

import com.example.nativesample01.data.util.database.TodoDao
import com.example.nativesample01.data.util.database.TodoEntity
import javax.inject.Inject

class HomeLocalDataSourceImpl @Inject constructor(
    private val dao: TodoDao
) : HomeLocalDataSource {
    override suspend fun fetchTodos(): List<TodoEntity> = dao.getAll()
}