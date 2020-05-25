package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TaskTest {

    @Test
    fun `deve gerar identificador quando criar nova instancia`() {
        val task = Task(name = "task test")
        assertThat(task.uuid).isNotBlank()
        assertThat(task.uuid.length).isEqualTo(36)
    }
}