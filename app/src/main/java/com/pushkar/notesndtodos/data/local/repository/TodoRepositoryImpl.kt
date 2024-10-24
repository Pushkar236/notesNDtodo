package com.pushkar.notesndtodos.data.local.repository

import com.pushkar.notesndtodos.data.local.dao.TodoDao
import com.pushkar.notesndtodos.data.model.Todo
import com.pushkar.notesndtodos.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor( private val todoDao: TodoDao) : TodoRepository {
    override fun getAllTodos(): Flow<List<Todo>> {
        return todoDao.getAllTodos()
    }

    override suspend fun insertTodo(todo: Todo) {
        todoDao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(todo)
    }

    override suspend fun searchTodos(query: String): Flow<List<Todo>?> {
        return todoDao.searchTodos(query)
    }

    override suspend fun countCheckedTodos(): Flow<Int> {
        return todoDao.countCheckedTodos()
    }

}