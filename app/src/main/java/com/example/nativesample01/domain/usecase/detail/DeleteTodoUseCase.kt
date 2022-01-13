package com.example.nativesample01.domain.usecase.detail

import com.example.nativesample01.data.util.database.model.TodoModel
import com.example.nativesample01.domain.repository.detail.DetailRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DeleteTodoUseCase @Inject constructor(
    private val detailRepository: DetailRepository
){
    suspend operator fun invoke(todoModel: TodoModel) = detailRepository.deleteTodo(todoModel)
}