package com.example.retrofit_test1

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.retrofit_test1.model.Todo
import com.example.retrofit_test1.ui.theme.Retrofit_test1Theme
import com.example.retrofit_test1.ui.theme.bodyBackground
import com.example.retrofit_test1.ui.theme.topBarColor
import com.example.retrofit_test1.view.TodoRow
import com.example.retrofit_test1.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    val context = this
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
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
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { TopAppBar(
                            title = { Text(text = "TodoList")},
                            colors = TopAppBarDefaults.smallTopAppBarColors(
                                containerColor = Color(topBarColor.value)
                            )
                                    )
                                 }
                    ){padding ->
                        TodoList(movieList = todoViewModel.movieListResponse,padding)
                        todoViewModel.getMovieList()
                    }
                }
            }
        }
    }
}

@Composable
fun TodoList(movieList: List<Todo>,innerPadding: PaddingValues) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .background(bodyBackground)
    ){
        itemsIndexed(items = movieList){index, item->
            TodoRow(todo = item, context)
        }
    }
    
}
//@Preview
//@Composable
//fun preview(){
//    val todo = Todo(
//        completed = true,
//        id = 10,
//        title = "Market",
//        userId = 20
//    )
//    TodoRow(todo = todo)
//}