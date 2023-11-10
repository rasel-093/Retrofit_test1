package com.example.retrofit_test1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofit_test1.model.TodoItem
import com.example.retrofit_test1.ui.theme.Retrofit_test1Theme
import com.example.retrofit_test1.view.TodoItem
import com.example.retrofit_test1.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val todoViewModel by viewModels<TodoViewModel>()
            Retrofit_test1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoList(movieList = todoViewModel.movieListResponse)
                    todoViewModel.getMovieList()
                }
            }
        }
    }
}

@Composable
fun TodoList(movieList: List<TodoItem>) {
    LazyColumn{
        itemsIndexed(items = movieList){index, item->
            TodoItem(todo = item)
        }
    }
    
}
@Preview
@Composable
fun preview(){
    val todo = TodoItem(
        completed = true,
        id = 10,
        title = "Market",
        userId = 20
    )
    TodoItem(todo = todo)
}