package com.example.contactapp.MainUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactapp.Database.Entity.Contacts
import com.example.contactapp.Database.ViewModel.MainViewModel
import com.example.contactapp.R
import java.text.SimpleDateFormat

@Composable
fun dailPage(viewModel: MainViewModel) {

    val quickSand = FontFamily(Font(R.font.quicksand))
    val number = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = number.value,
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                fontFamily = quickSand
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { if (number.value.length < 10) number.value += "1" },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "1", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { if (number.value.length < 10) number.value += "2" },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))) {
                Text(text = "2", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { if (number.value.length < 10) number.value += "3" },
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
                onClick = { if (number.value.length < 10) number.value += "4" },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))) {
                Text(text = "4", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { if (number.value.length < 10)  number.value += "5" },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))) {
                Text(text = "5", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { if (number.value.length < 10) number.value += "6" },
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
                onClick = { if (number.value.length < 10) number.value += "7" },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "7", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { if (number.value.length < 10) number.value += "8" },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "8", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { if (number.value.length < 10) number.value += "9" },
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
                onClick = { number.value += "*" },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "*", fontFamily = quickSand, fontSize = 40.sp, color = Color.Black)
            }
            Button(
                onClick = { if (number.value.length < 10) number.value += "0" },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "0", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
            Button(
                onClick = { number.value += "#" },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E2E2)),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Text(text = "#", fontFamily = quickSand, fontSize = 20.sp, color = Color.Black)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(
                onClick = { number.value = number.value.dropLast(1) },
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFE2E2E2))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.clear_black),
                    contentDescription = "",
                    Modifier.size(25.dp)
                )
            }
            IconButton(
                onClick = {
                    val currentTime = System.currentTimeMillis()
                    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    val formattedTime = sdf.format(currentTime)
                    val Con = Contacts(name = "unknown",phone = number.value, favorite = false)
                    viewModel.addRecent(contact = Con, time = formattedTime)
                          },
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFE2E2E2))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.phone_green1),
                    contentDescription = "",
                    Modifier.size(35.dp)
                )
            }
            Spacer(modifier = Modifier.width(60.dp))
        }
        Spacer(modifier = Modifier.height(80.dp))
    }
}