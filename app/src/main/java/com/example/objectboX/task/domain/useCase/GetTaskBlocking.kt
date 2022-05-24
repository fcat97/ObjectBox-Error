package com.example.objectboX.task.domain.useCase

import com.example.objectboX.task.domain.repository.TaskRepository

class GetTaskBlocking(
    private val taskRepository: TaskRepository
) {
    operator fun invoke(taskID: String) = taskRepository.getTaskBlocking(taskID)
}