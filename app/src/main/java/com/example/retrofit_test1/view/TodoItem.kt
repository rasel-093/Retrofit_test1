package com.example.retrofit_test1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.retrofit_test1.R
import com.example.retrofit_test1.model.TodoItem

@Composable
fun TodoItem(todo: TodoItem) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Surface {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.done_icon) ,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                    )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = todo.title, //movie.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )

                    Text(
                        text = todo.completed.toString(), //movie.category,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(4.dp)
                    )

                    Text(
                        text =  todo.userId.toString(),//movie.desc,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}


//painter = rememberImagePainter(
//data = movie.imageUrl,
//builder = {
//    scale(Scale.FILL)
//    placeholder(androidx.core.R.drawable.notification_action_background)
//    transformations(CircleCropTransformation())
//}
//),