package com.example.retrofit_test1.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.retrofit_test1.R

data class Todo(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
){
    @Composable
    fun icon(): Painter =
        if(completed) painterResource(id = R.drawable.checked_icon)
        else painterResource(id = R.drawable.unchecked_icon)

    fun completeString(): String = if(completed) "Completed" else "Incomplete"
    fun color(): Color = if(completed) Color(0xFF3EF045) else Color(  0xFFEB5B83)
}