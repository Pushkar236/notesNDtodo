package com.pushkar.notesndtodos.domain.repository

import com.pushkar.notesndtodos.data.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getAllTodos(): Flow<List<Todo>>
    suspend fun insertTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
    suspend fun searchTodos(query: String): Flow<List<Todo>?>
    suspend fun countCheckedTodos(): Flow<Int>
}