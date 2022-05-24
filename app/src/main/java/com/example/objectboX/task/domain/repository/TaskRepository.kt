package com.example.objectboX.task.domain.repository

import io.objectbox.android.ObjectBoxLiveData
import com.example.objectboX.task.domain.model.Task
import com.example.objectboX.task.domain.model.TaskTag

interface TaskRepository {
    fun getAllTask(): ObjectBoxLiveData<Task>
    fun getAllTaskTags(): ObjectBoxLiveData<TaskTag>

    suspend fun getTask(taskID: String): Task?
    fun getTaskBlocking(taskID: String): Task?
    suspend fun insertTask(task: Task)
    suspend fun insertTag(tag: TaskTag)
    fun updateAsync(task: Task)
}