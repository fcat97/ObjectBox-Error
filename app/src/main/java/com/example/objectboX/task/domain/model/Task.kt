package com.example.objectboX.task.domain.model

import com.example.objectboX.task.utils.IdGenerator
import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

/**
 * Entity class of Task
 */
@Entity
class Task {
    /**
     * ObjectBox ID
     */
    @Id var id: Long = 0

    /**
     * permanent ID
     */
    val taskID: String = IdGenerator.getNewId()


    /**
     * Title of the task
     */
    var title = ""


    /**
     * ObjectBox Reference to [TaskTag]
     */
    @Backlink(to  = "task")
    lateinit var tags: ToMany<TaskTag>

}