package com.example.contactapp.MainUI

import  com.example.contactapp.Database.Entity.Contacts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactapp.Database.ViewModel.MainViewModel
import com.example.contactapp.R
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import java.text.SimpleDateFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun recentPage(viewModel: MainViewModel) {

    val quickSand = FontFamily(Font(R.font.quicksand))
    viewModel.getAllRecents()
    val recents = viewModel.allRecents.observeAsState()



    Column(Modifier.fillMaxSize()) {
        TopAppBar(title = { Text(text = "Recent", fontFamily = quickSand, fontSize = 20.sp) })
        if (!recents.value.isNullOrEmpty())
        LazyColumn{
            items(items = recents.value!!){recent ->
                val call = SwipeAction(
                    onSwipe = {
                        val currentTime = System.currentTimeMillis()
                        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        val formattedTime = sdf.format(currentTime)
                        val con = Contacts(name = recent.name ?: "", phone = recent.phone, favorite = false)
                        viewModel.addRecent(contact = con, time = formattedTime) },
                    icon = {
                        Icon(
                            modifier = Modifier.padding(16.dp),
                            imageVector = Icons.Default.Phone,
                            contentDescription = "",
                            tint = Color.White
                        )
                    },
                    background = Color.Green
                )
                val delete = SwipeAction(
                    onSwipe = { viewModel.deleteRecent(recent) },
                    icon = {
                        Icon(
                            modifier = Modifier.padding(16.dp),
                            imageVector = Icons.Default.Delete,
                            contentDescription = "",
                            tint = Color.White
                        )
                    },
                    background = Color.Red
                )
                SwipeableActionsBox(
                    startActions = listOf(call),
                    endActions = listOf(delete),
                    swipeThreshold = 150.dp
                ) {
                    recentListModel(name = recent.name ?: "" , phone = recent.phone, time = recent.time.substring(10,16))
                }
            }
        }
    }

}