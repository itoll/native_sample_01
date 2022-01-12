package com.example.nativesample01.data.util.mapper

import com.example.nativesample01.data.dataSource.home.local.model.TodoModel
import com.example.nativesample01.data.util.database.TodoEntity
import javax.inject.Inject

class TodoMapper @Inject constructor() : MapEntityToModel<TodoEntity, TodoModel> {
    override fun toModel(entity: TodoEntity): TodoModel {
        return TodoModel(
            entity.id,
            entity.title,
            entity.description,
            entity.isDone
        )
    }

    override fun toEntity(model: TodoModel): TodoEntity {
        return TodoEntity(
            model.id,
            model.title,
            model.description,
            model.isDone
        )
    }
}