package com.example.contactapp.MainUI

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun contactPage() {

    val quickSand = FontFamily(Font(R.font.quicksand))

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
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(start = 8.dp)
        ){
            items(10) {
                frequentModel()
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
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

        LazyColumn{
            items(10){
                contactListModel()
            }
        }
    }
}