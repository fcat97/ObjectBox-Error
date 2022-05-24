package com.example.objectboX.task.domain.useCase

import com.example.objectboX.task.domain.repository.TaskRepository

class GetTask(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(taskID: String) = taskRepository.getTask(taskID)
}