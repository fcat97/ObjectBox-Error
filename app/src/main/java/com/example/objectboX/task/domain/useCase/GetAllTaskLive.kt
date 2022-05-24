package com.example.objectboX.task.domain.useCase

import com.example.objectboX.task.domain.repository.TaskRepository

class GetAllTaskLive(
    private val taskRepository: TaskRepository
) {
    operator fun invoke() = taskRepository.getAllTask()
}