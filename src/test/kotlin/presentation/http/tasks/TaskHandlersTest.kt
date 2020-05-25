package presentation.http.tasks

import kong.unirest.HttpResponse
import kong.unirest.Unirest
import newApp
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class TaskHandlerTest {

    @Test
    fun `deve retornar 201 em caso de sucesso`() = realServerTest(port = 1234) {
        //Test
        val response: AddTaskResponse = Unirest.post("http://localhost:1234/tasks")
            .header("Content-Type", "application/json")
            .body(AddTaskRequest("task1")).asObject(AddTaskResponse::class.java).body

        //Test
        assertThat(response).isEqualToIgnoringGivenFields(AddTaskResponse(name = "task1", id = ""), "id")
        assertThat(response.id).isNotBlank()
    }

    @Test
    fun `deve retornar 400 quando nome for invalido`() = realServerTest(port = 1235) {
        //Test
        val response: HttpResponse<String> = Unirest.post("http://localhost:1235/tasks")
            .header("Content-Type", "application/json")
            .body(AddTaskRequest(" ")).asString()

        //Test
        assertThat(response.status).isEqualTo(400)
        assertThat(response.body).isEqualTo("Request body as AddTaskRequest invalid - cannot be empty")
    }

    fun realServerTest(port: Int = 1234, fn: () -> Unit) {
        val app = newApp()!!
        app.start(port)
        fn()
        app.stop()
    }
}