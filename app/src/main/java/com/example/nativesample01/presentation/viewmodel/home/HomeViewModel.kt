package com.example.nativesample01.presentation.viewmodel.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nativesample01.data.dataSource.home.local.model.TodoModel
import com.example.nativesample01.domain.usecase.FetchTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchTodosUseCase: FetchTodosUseCase
) : ViewModel() {

    val todos = mutableStateListOf<TodoModel>()

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            todos.addAll(fetchTodosUseCase.invoke())
        }
    }


}