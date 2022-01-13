package com.example.nativesample01.presentation.ui.screen.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nativesample01.data.util.database.model.TodoModel
import com.example.nativesample01.presentation.ui.theme.NativeSample01Theme
import com.example.nativesample01.presentation.viewmodel.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(viewModel = viewModel())
        }
    }
}

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    NativeSample01Theme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.LightGray)
                .padding(vertical = 8.dp)
        ) {
            LazyColumn(modifier = Modifier) {
                itemsIndexed(viewModel.todos) { _, item ->
                    TodoListItem(todoModel = item)
                }
            }
        }
    }

}

@Composable
fun TodoListItem(todoModel: TodoModel) {
    Surface(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(80.dp)
//            .background(color = Color(0xffe0e0e0))
            .background(color = Color.Blue)
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .shadow(elevation = 4.dp)
            ,
        shape = RoundedCornerShape(size = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
//                .height(46.dp)

                .background(color = Color.Transparent)
//                .padding(horizontal = 8.dp)
            ,

            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Red),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "${todoModel.title[0].uppercaseChar()}",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                todoModel.title, style = TextStyle(
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
        }
    }

}

@Preview()
@Composable
fun previewTodoListItem(){
    val tmp = TodoModel(1, "Jetpack Compose",  "Kir t0 AkhonDa", true)
    
    TodoListItem(todoModel = tmp)
}
