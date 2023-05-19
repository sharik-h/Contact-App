package com.example.contactapp.MainUI

import android.provider.ContactsContract.Contacts
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.example.contactapp.Database.ViewModel.MainViewModel
import com.example.contactapp.Navigation.BottomBarScreen
import com.example.contactapp.R
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import java.sql.Time
import java.text.SimpleDateFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun contactPage(viewModel: MainViewModel, navController: NavController) {

    val quickSand = FontFamily(Font(R.font.quicksand))
    val contacts = viewModel.allContacts.observeAsState()
    val recents = viewModel.allRecents.observeAsState()
    val search = remember { mutableStateOf("") }
    if (search.value == "") viewModel.getAllContacts()
    viewModel.getAllRecents()

    Column(Modifier.fillMaxSize()) {
        TopAppBar(navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.user_default1),
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            )
        },title = {
            Column {
                Text(text = "User Name", fontSize = 17.sp, fontFamily = quickSand)
                Text(text = "(n) Contact", fontSize = 15.sp, fontFamily = quickSand)
            }
        }, actions = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFF0F0F0))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.info_black),
                    contentDescription = "",
                    modifier = Modifier.size(15.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        },
        )
        Text(
            text = "Recent",
            fontSize = 20.sp,
            fontFamily = quickSand,
            modifier = Modifier.padding(start = 15.dp)
        )
        if (!recents.value.isNullOrEmpty()) {
            LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(start = 8.dp)
        ) {
                items(recents.value!!) { recent ->
                    frequentModel(name = recent.name ?: "")
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = search.value,
                onValueChange = {
                    search.value = it
                    viewModel.searchContact(search.value)
                                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Transparent,
                    containerColor = Color(0xFFEBEBEB)),
                leadingIcon = {
                    Image(painter = painterResource(id = R.drawable.search_blue), contentDescription = "")
                },
                placeholder = {
                    Text(
                        text = "Search...",
                        fontFamily = quickSand,
                        fontSize = 15.sp,
                        color = Color.Gray
                    )
                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        if (!contacts.value.isNullOrEmpty()){
            LazyColumn{
                items(items = contacts.value!!){ contact ->
                    val edit = SwipeAction(
                        onSwipe = { navController.navigate(BottomBarScreen.add.passData(id = contact.id)) },
                        icon ={
                              Icon(
                                  modifier = Modifier.padding(16.dp),
                                  imageVector = Icons.Default.Edit,
                                  contentDescription = "",
                                  tint = Color.White
                              )
                        },
                        background = MaterialTheme.colorScheme.primary,
                    )
                    val delete = SwipeAction(
                        onSwipe = { viewModel.deleteContact(contact = contact) },
                        icon = {
                            Icon(
                                modifier = Modifier.padding(16.dp),
                                imageVector = Icons.Default.Delete,
                                contentDescription = "",
                                tint = White
                            )
                        },
                        background = Color.Red
                    )
                    SwipeableActionsBox(
                        startActions = listOf(delete),
                        endActions = listOf(edit),
                        swipeThreshold = 150.dp
                    ) {
                        contactListModel(name = contact.name, phone = contact.phone, favorite = contact.favorite){it ->
                            if (it == "favorite"){
                                viewModel.updateFavorite(id = contact.id, fav = !contact.favorite)
                            }else if (it == "call"){
                                val currentTime = System.currentTimeMillis()
                                val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                val formattedTime = sdf.format(currentTime)
                                viewModel.addRecent(contact = contact, time = formattedTime)
                            }
                        }
                    }
                }
            }
        }
    }
}