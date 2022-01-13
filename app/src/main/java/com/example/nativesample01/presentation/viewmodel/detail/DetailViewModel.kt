package com.example.nativesample01.presentation.viewmodel.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nativesample01.data.util.database.model.TodoModel
import com.example.nativesample01.domain.usecase.detail.DeleteTodoUseCase
import com.example.nativesample01.domain.usecase.detail.FetchTodoUsingIdUseCase
import com.example.nativesample01.domain.usecase.detail.InsertTodoUseCase
import com.example.nativesample01.domain.usecase.detail.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val fetchTodoUsingIdUseCase: FetchTodoUsingIdUseCase,
    private val insertTodoUseCase: InsertTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
) : ViewModel() {
    private val currentTodoLiveData: MutableLiveData<TodoModel> = MutableLiveData()

    fun fetchTodoUsingId(id:Long) {
        viewModelScope.launch {
            val todoModel = fetchTodoUsingIdUseCase.invoke(id)
            currentTodoLiveData.value = todoModel
        }
    }

    fun insertTodo(todoModel: TodoModel){
        viewModelScope.launch {
            insertTodoUseCase(todoModel)
        }
    }

    fun updateTodo(todoModel: TodoModel) {
        viewModelScope.launch {
            updateTodoUseCase(todoModel)
        }
    }

    fun deleteTodo(todoModel: TodoModel) {
        viewModelScope.launch {
            deleteTodoUseCase(todoModel)
        }
    }
}