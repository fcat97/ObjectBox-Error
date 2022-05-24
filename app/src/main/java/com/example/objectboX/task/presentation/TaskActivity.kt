package com.example.objectboX.task.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.objectboX.task.domain.model.Task
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val task  = Task()
        val tags = task.tags.map { it.name }.joinToString { it }

        setContent {
            MaterialTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Hello ObjectBox!",
                        fontSize = 40.sp,
                        color = MaterialTheme.colors.onSurface
                    )
                }
            }
        }
    }
}

