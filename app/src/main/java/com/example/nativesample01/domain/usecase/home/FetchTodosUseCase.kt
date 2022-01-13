package com.example.nativesample01.domain.usecase.home

import com.example.nativesample01.data.util.database.model.TodoModel
import com.example.nativesample01.domain.repository.home.HomeRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


@ViewModelScoped
class FetchTodosUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
     suspend operator fun invoke():List<TodoModel> {
        return homeRepository.fetchTodos()
    }
}