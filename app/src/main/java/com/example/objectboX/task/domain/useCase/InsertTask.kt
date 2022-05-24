package com.example.objectboX.task.domain.useCase

import com.example.objectboX.task.domain.repository.TaskRepository
import com.example.objectboX.task.domain.model.Task

class InsertTask(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(task: Task) = taskRepository.insertTask(task)
}