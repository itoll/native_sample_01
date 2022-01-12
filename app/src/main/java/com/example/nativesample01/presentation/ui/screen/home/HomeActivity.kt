package com.example.nativesample01.presentation.ui.screen.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nativesample01.data.dataSource.home.local.model.TodoModel
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
                .background(color = Color(0xfff3f3f3))
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
    Text(todoModel.title)
}