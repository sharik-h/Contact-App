package com.example.contactapp.MainUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactapp.R

@Composable
fun recentListModel(name: String, phone: String, time:String) {
     val quickSand = FontFamily(Font(R.font.quicksand))
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
            Text(text = time, fontFamily = quickSand, fontSize = 17.sp, color = Color.LightGray)
            Spacer(modifier = Modifier.width(10.dp))
        }
        Divider(modifier = Modifier.padding(25.dp))
    }
}