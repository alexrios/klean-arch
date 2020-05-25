package domain.task

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AddTaskTest {

    @Test
    fun `deve retornar a task criada em caso de sucesso com ID preenchido`() {
        //Prepare
        val addTask = AddTask(FakeSaveGateway())
        //Test
        val output = addTask.Add(AddInput("task 1"))
        //Assertions
        with(output as AddOutput.Success) {
            assertThat(this.task.uuid).isNotBlank()
            assertThat(this.task.name).isEqualTo("task 1")
        }
    }

    @Test
    fun `deve retornar a mensagem de erro nos casos de erro`() {
        //Prepare
        val addTask = AddTask(FakeSaveGateway(error = true))
        //Test
        val output = addTask.Add(AddInput("todo error"))
        //Assertions
        with(output as AddOutput.Error) {
            assertThat(this.msg).isNotBlank()
        }
    }
}