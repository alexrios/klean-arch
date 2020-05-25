package domain.task

import domain.Task

fun AddInput.toDomain(): Task {
    return Task(name = this.name)
}

class AddTask(val taskGateway: TaskGateway) : AddTaskUseCase {
    override fun Add(input: AddInput) =
        when (val result = taskGateway.Save(SaveInput(input.toDomain()))) {
            is SaveOutput.Success -> AddOutput.Success(result.task)
            is SaveOutput.Error -> AddOutput.Error(msg = result.msg, ex = result.ex)
        }
}