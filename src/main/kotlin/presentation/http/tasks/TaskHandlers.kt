package presentation.http.tasks

import domain.Task
import domain.task.AddInput
import domain.task.AddOutput
import domain.task.AddTaskUseCase
import io.javalin.http.Context

data class AddTaskRequest(val name: String)
data class AddTaskResponse(val id: String, val name: String)

fun fromTask(task: Task): AddTaskResponse = AddTaskResponse(id = task.uuid, name = task.name)

class TaskHandlers(val uc: AddTaskUseCase) {
    fun addTaskHandler(ctx: Context) {
        val newTask = ctx.bodyValidator<AddTaskRequest>()
            .check({ it.name.isNotBlank() }, "cannot be empty")
            .get()

        when (val result = uc.Add(AddInput(name = newTask.name))) {
            is AddOutput.Success -> {
                ctx.status(201)
                ctx.json(fromTask(result.task))
            }
            is AddOutput.Error -> {
                ctx.status(500)
            }
        }

    }
}