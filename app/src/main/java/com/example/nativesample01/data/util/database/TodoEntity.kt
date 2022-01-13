package com.example.nativesample01.data.util.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TodoConstants.TABLE_NAME)
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = TodoConstants.COLUMN_ID)
    val id: Int,
    val title: String,
    val description: String,
    @ColumnInfo(name = TodoConstants.COLUMN_IS_DONE)
    val isDone: Boolean,
)
