package com.example.objectboX.task.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.objectboX.task.domain.useCase.TaskUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases,
): ViewModel() {
    val allTasksLive = taskUseCases.getAllTaskLive()
    val allTasksTagLive = taskUseCases.getAllTaskTagLive()
}