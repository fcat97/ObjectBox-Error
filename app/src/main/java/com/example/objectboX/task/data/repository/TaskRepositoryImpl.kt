package com.example.objectboX.task.data.repository

import io.objectbox.Box
import io.objectbox.android.ObjectBoxLiveData
import io.objectbox.exception.UniqueViolationException
import com.example.objectboX.task.domain.repository.TaskRepository
import com.example.objectboX.task.domain.model.Task
import com.example.objectboX.task.domain.model.TaskTag
import com.example.objectboX.task.domain.model.TaskTag_
import com.example.objectboX.task.domain.model.Task_

class TaskRepositoryImpl(
    private val taskBox: Box<Task>,
    private val taskTagBox: Box<TaskTag>
): TaskRepository {
    override fun getAllTask(): ObjectBoxLiveData<Task> {
       return ObjectBoxLiveData(taskBox.query().build())
    }

    override fun getAllTaskTags(): ObjectBoxLiveData<TaskTag> {
        return  ObjectBoxLiveData(taskTagBox.query().build())
    }

    override suspend fun getTask(taskID: String): Task? {
        return taskBox.query(Task_.taskID.equal(taskID)).build().findFirst()
    }

    override fun getTaskBlocking(taskID: String): Task? {
        return taskBox.query(Task_.taskID.equal(taskID)).build().findFirst()
    }

    override suspend fun insertTask(task: Task) {
        val tags = task.tags.map {
            it.name = it.name.trim()
            it
        }.filter { it.name.isNotBlank() }

        tags.forEach {
            // it will fail if tag with same name exists
            try {
                taskTagBox.put(it)
            } catch (failed: UniqueViolationException) {}
        }

        val tagList: MutableList<TaskTag> = mutableListOf()
        tags.forEach {
            taskTagBox.query(TaskTag_.name.equal(it.name))
                .build().findFirst()
                ?.also { t -> tagList.add(t) }
        }

        task.tags.clear()
        task.tags.addAll(tagList)

        taskBox.put(task)
    }

    override suspend fun insertTag(tag: TaskTag) {
        try {
            taskTagBox.put(tag)
        } catch (e: UniqueViolationException) {}
    }

    override fun updateAsync(task: Task) {
        taskBox.put(task)
    }
}