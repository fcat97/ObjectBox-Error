package com.example.objectboX.task.domain.useCase

import com.example.objectboX.task.domain.model.Task
import com.example.objectboX.task.domain.repository.TaskRepository

class UpdateTaskAsync(
    private val taskRepository: TaskRepository
) {
    operator fun invoke(task: Task) = taskRepository.updateAsync(task)
}