package domain

import java.util.*

data class Task(
    val uuid: String = UUID.randomUUID().toString(),
    val name: String
)