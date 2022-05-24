package com.example.objectboX.task.domain.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import io.objectbox.relation.ToMany

@Entity
class TaskTag(
    @Id var id: Long = 0,
    @Unique var name: String = "",
) {

//    @Backlink(to = "tags")
    lateinit var task: ToMany<Task>

}