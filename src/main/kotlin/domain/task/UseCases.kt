package domain.task

import domain.Task

data class AddInput(val name: String)
sealed class AddOutput {
    data class Success(val task: Task) : AddOutput()
    data class Error(val msg: String, val ex: Throwable?) : AddOutput()
}

interface AddTaskUseCase {
    fun Add(input: AddInput): AddOutput
}