package domain.task

import domain.Task

data class SaveInput(val newTask: Task)
sealed class SaveOutput {
    data class Success(val task: Task) : SaveOutput()
    data class Error(val msg: String, val ex: Throwable?) : SaveOutput()
}

interface TaskGateway {
    fun Save(input: SaveInput): SaveOutput
}