package com.example.contactapp.MainUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.contactapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun recentPage() {

    val quickSand = FontFamily(Font(R.font.quicksand))

    Column(Modifier.fillMaxSize()) {
        TopAppBar(title = { Text(text = "Recent", fontFamily = quickSand, fontSize = 20.sp) })
        LazyColumn{
            items(10){
                contactListModel()
            }
        }
    }

}