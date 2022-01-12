package com.example.nativesample01.data.util.mapper

interface MapEntityToModel<E, M> {
    fun toModel(entity: E): M
    fun toEntity(model: M): E
}