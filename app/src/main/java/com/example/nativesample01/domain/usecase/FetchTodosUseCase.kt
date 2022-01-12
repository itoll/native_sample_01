package com.example.nativesample01.domain.usecase

import com.example.nativesample01.data.dataSource.home.local.model.TodoModel
import com.example.nativesample01.domain.repository.home.HomeRepository
import javax.inject.Inject

class FetchTodosUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
     suspend operator fun invoke():List<TodoModel> {
        return homeRepository.fetchTodos()
    }
}