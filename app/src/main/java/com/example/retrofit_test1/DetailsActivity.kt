package com.example.retrofit_test1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit_test1.ui.theme.Retrofit_test1Theme
import com.example.retrofit_test1.ui.theme.bodyBackground
import com.example.retrofit_test1.ui.theme.itemBackGroundColor
import com.example.retrofit_test1.ui.theme.topBarColor

class DetailsActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Retrofit_test1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val title = intent.getStringExtra("title")
                    val completed = intent.getStringExtra("complete")
                    val todoId = intent.getStringExtra("todoId")
                    val userId = intent.getStringExtra("userId")
                    Scaffold(
                        topBar = { TopAppBar(
                            title = { Text(text = "Details") },
                            colors = TopAppBarDefaults.smallTopAppBarColors(
                                containerColor = Color(topBarColor.value)
                            )
                            )}
                    ) { paddingValues ->
                        OutlinedCard(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(bodyBackground.value)
                            )
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Column(
                                    modifier= Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                        .border(BorderStroke(1.dp, Color.DarkGray))
                                        .background(itemBackGroundColor)
//                                        .clip(RoundedCornerShape(8.dp))
                                ){
                                    Text(
                                        text = "Task Title",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp,
                                        modifier = Modifier.padding(5.dp)
                                    )
                                    Text(
                                        text = "${title.toString()}",
                                        modifier = Modifier.padding(5.dp)
                                    )
                                }
                                Column(modifier= Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .border(BorderStroke(1.dp, Color.DarkGray))
                                    .background(itemBackGroundColor)){
                                    Text(
                                        text = "Task Status",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp,
                                        modifier = Modifier.padding(5.dp)
                                    )
                                    Text(
                                        text = "${completed.toString()}",
                                        modifier = Modifier.padding(5.dp)
                                    )

                                }
                                Column(modifier= Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .border(BorderStroke(1.dp, Color.DarkGray))
                                    .background(itemBackGroundColor)){
                                    Text(
                                        text = "Task Id",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp,
                                        modifier = Modifier.padding(5.dp)
                                    )
                                    Text(
                                        text = "${todoId.toString()}",
                                        modifier = Modifier.padding(5.dp)
                                    )
                                }
                                Column(modifier= Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .border(BorderStroke(1.dp, Color.DarkGray))
                                    .background(itemBackGroundColor)){
                                    Text(
                                        text = "User Id",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp,
                                        modifier = Modifier.padding(5.dp)
                                    )
                                    Text(
                                        text = "${userId.toString()}",
                                        modifier = Modifier.padding(5.dp)
                                    )
                                }
                            }

                    }
                    }
                }
            }
        }
    }
}