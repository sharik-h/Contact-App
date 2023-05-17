package com.example.contactapp.MainUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun dailPage() {

    val quickSand = FontFamily(Font(R.font.quicksand))
    val numbers = listOf(1,2,3,4,5,6,7,8,9,-1,0)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "1", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))) {
                Text(text = "2", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))) {
                Text(text = "3", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))) {
                Text(text = "4", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))) {
                Text(text = "5", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "6", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "7", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "8", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "9", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "*", fontFamily = quickSand, fontSize = 40.sp, color = Color.Black)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "0", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "#", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFE2E2E2))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.phone_green),
                    contentDescription = "",
                    Modifier.size(35.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}