package com.example.retrofit_test1.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.retrofit_test1.model.Todo

@Composable
fun TodoRow(todo: Todo) {
    OutlinedCard(
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surface,
//        ),
        border = BorderStroke(2.dp, Color.LightGray),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Surface {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = todo.icon(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f),
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.Center
                    )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = todo.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )

                    Text(
                        text = "${todo.completeString()}",
                        style = MaterialTheme.typography.titleSmall,
                        color = todo.color(),
                        modifier = Modifier
                            //.background(Color.LightGray)
                            .padding(4.dp)
                    )

                    Text(
                        text = "User Id: ${todo.userId}",
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}