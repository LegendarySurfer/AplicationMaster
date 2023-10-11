package com.cursillokotlin.todoapp

sealed class TaskCategory {
    object Personal: TaskCategory()
    object Buisiness: TaskCategory()
    object Other: TaskCategory()

}