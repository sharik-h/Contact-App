package com.example.contactapp.MainUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactapp.R

@Preview(showBackground = true)
@Composable
fun contactListModel() {

    val quickSand = FontFamily(Font(R.font.quicksand))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.user_default1),
            contentDescription = "",
            modifier = Modifier.size(50.dp)
        )
        Column {
            Text(text = "User Name", fontSize = 17.sp, fontFamily = quickSand)
            Text(text = "(n) Contact", fontSize = 15.sp, fontFamily = quickSand)
        }
        Spacer(modifier = Modifier.weight(0.1f))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFFF0F0F0))
        ) {
            Image(
                painter = painterResource(id = R.drawable.phone_green),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
        }
    }
    Divider(modifier = Modifier.padding(15.dp))

}