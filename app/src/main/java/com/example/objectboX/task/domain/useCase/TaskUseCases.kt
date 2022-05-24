package com.example.objectboX.task.domain.useCase

data class TaskUseCases(
    val getAllTaskLive: GetAllTaskLive,
    val getAllTaskTagLive: GetAllTaskTagLive,
    val getTask: GetTask,
    val getTaskBlocking: GetTaskBlocking,
    val insertTask: InsertTask,
    val insertTag: InsertTag,
    val updateTaskAsync: UpdateTaskAsync
)