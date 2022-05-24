package com.example.objectboX.task.domain.useCase

import com.example.objectboX.task.domain.model.TaskTag
import com.example.objectboX.task.domain.repository.TaskRepository

class InsertTag(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(tag: TaskTag) {
        taskRepository.insertTag(tag)
    }
}