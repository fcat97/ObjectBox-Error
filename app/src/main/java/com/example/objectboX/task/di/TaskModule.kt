package com.example.objectboX.task.di

import android.content.Context
import com.example.objectboX.task.data.repository.TaskRepositoryImpl
import com.example.objectboX.task.domain.model.MyObjectBox
import com.example.objectboX.task.domain.model.Task
import com.example.objectboX.task.domain.model.TaskTag
import com.example.objectboX.task.domain.repository.TaskRepository
import com.example.objectboX.task.domain.useCase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TaskModule {

    @Provides
    @Singleton
    fun provideBoxStore(
        @ApplicationContext context: Context
    ): BoxStore {
        return MyObjectBox.builder()
            .androidContext(context)
            .build()
    }

    @Provides
    @Singleton
    fun provideTaskUseCases(
        taskRepository: TaskRepository
    ): TaskUseCases {
        return TaskUseCases(
            getAllTaskLive = GetAllTaskLive(taskRepository),
            getAllTaskTagLive = GetAllTaskTagLive(taskRepository),
            getTask = GetTask(taskRepository),
            insertTask = InsertTask(taskRepository),
            insertTag = InsertTag(taskRepository),
            getTaskBlocking = GetTaskBlocking(taskRepository),
            updateTaskAsync = UpdateTaskAsync(taskRepository)
        )
    }

    @Provides
    @Singleton
    fun provideTaskRepository(
        boxStore: BoxStore
    ): TaskRepository {
        return TaskRepositoryImpl (
            taskBox = boxStore.boxFor(Task::class.java),
            taskTagBox = boxStore.boxFor(TaskTag::class.java)
        )
    }
}