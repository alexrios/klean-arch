import domain.task.AddTask
import gateways.memdb.task.InMemoryTask
import io.javalin.Javalin
import io.javalin.Javalin.create
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post
import presentation.http.tasks.TaskHandlers

fun main() {
    newApp()?.start()
}

fun newApp(): Javalin? {
    val app = create()
    //Dependency injection
    val taskHandlers = TaskHandlers(AddTask(InMemoryTask()))
    app.routes {
        path("tasks") {
            post { ctx -> taskHandlers.addTaskHandler(ctx) }
        }
    }
    return app
}