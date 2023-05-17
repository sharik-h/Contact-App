package com.example.contactapp.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object contacts: BottomBarScreen(
        route = "contacts",
        title = "contacts",
        icon = Icons.Default.Person
    )
    object recents: BottomBarScreen(
        route = "recent",
        title = "recent",
        icon = Icons.Default.Refresh
    )
    object favorite: BottomBarScreen(
        route = "favorite",
        title = "favorite",
        icon = Icons.Default.Favorite
    )
    object dail: BottomBarScreen(
        route = "dail",
        title = "dail",
        icon = Icons.Default.Phone
    )
    object add: BottomBarScreen(
        route = "add",
        title = "add",
        icon = Icons.Default.Add
    )
}
