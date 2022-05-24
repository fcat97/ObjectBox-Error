package com.example.objectboX.task.domain.useCase

import com.example.objectboX.task.domain.repository.TaskRepository

class GetAllTaskTagLive(
    private val taskRepository: TaskRepository
) {
    operator fun invoke() = taskRepository.getAllTaskTags()
}