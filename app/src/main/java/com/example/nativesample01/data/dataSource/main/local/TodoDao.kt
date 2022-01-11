package com.example.nativesample01.data.dataSource.main.local

import androidx.room.*

@Dao
interface TodoDao {

    @Query("SELECT * FROM ${TodoConstants.TABLE_NAME}")
    suspend fun getAll(): List<TodoEntity>

    @Query("SELECT * FROM ${TodoConstants.TABLE_NAME} WHERE ${TodoConstants.COLUMN_IS_DONE} = :state")
    suspend fun getFilteredTodos(state: Boolean): List<TodoEntity>

    @Update
    suspend fun updateTodo(todo: TodoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoEntity)

    @Delete
    suspend fun deleteTodo(todo: TodoEntity)
}