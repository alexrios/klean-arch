package domain.task

import domain.Task
import fixtures.uuid1String

class FakeSaveGateway(val error: Boolean = false) : TaskGateway {
    override fun Save(input: SaveInput) =
        when (error) {
            false -> SaveOutput.Success(input.newTask)
            true -> SaveOutput.Error("test error", null)
        }


}

