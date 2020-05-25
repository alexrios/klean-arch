package gateways.memdb.task

import domain.task.SaveInput
import domain.task.SaveOutput
import domain.task.TaskGateway

class InMemoryTask : TaskGateway {
    override fun Save(input: SaveInput): SaveOutput {
        return SaveOutput.Success(input.newTask)
    }
}