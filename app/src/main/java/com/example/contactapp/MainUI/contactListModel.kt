package com.example.contactapp.MainUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactapp.Database.Entity.Favorite
import com.example.contactapp.R

@Composable
fun contactListModel(name: String, phone: String, favorite: Boolean, onclick: (String) -> Unit) {

    val quickSand = FontFamily(Font(R.font.quicksand))
    val isLiked = remember { mutableStateOf(favorite) }
Column(
    Modifier
        .fillMaxWidth()
        .height(70.dp)) {
    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 15.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.user_default1),
            contentDescription = "",
            modifier = Modifier.size(50.dp)
        )
        Column {
            Text(text = name, fontSize = 17.sp, fontFamily = quickSand)
            Text(text = phone, fontSize = 15.sp, fontFamily = quickSand)
        }
        Spacer(modifier = Modifier.weight(0.1f))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFFF0F0F0))
                .clickable { onclick("call") }
        ) {
            Image(
                painter = painterResource(id = R.drawable.phone_green),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.width(20.dp))

            IconButton(
                onClick = {
                    onclick("favorite")
                    isLiked.value = !isLiked.value
                          },
                colors = IconButtonDefaults.outlinedIconButtonColors(
                    contentColor = if (isLiked.value) Color.Red else Color.Gray,
                    disabledContentColor = Color.Gray),
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFF0F0F0))
                    .padding(all = 1.dp)
            ) {
                if (isLiked.value) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Like")
                } else {
                    Icon(Icons.Outlined.Favorite, contentDescription = "Like")
                }
            }
    }
    Divider(modifier = Modifier.padding(25.dp))
}

}