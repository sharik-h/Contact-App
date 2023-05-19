package com.example.contactapp.MainUI

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.contactapp.Database.Entity.Contacts
import com.example.contactapp.Database.ViewModel.MainViewModel
import com.example.contactapp.Navigation.BottomBarScreen
import com.example.contactapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newContactPage(viewModel: MainViewModel, navController: NavController, id: Int?) {

    val context = LocalContext.current
    val quickSand = FontFamily(Font(R.font.quicksand))
    val name =  remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val contact  = viewModel.contact.observeAsState()
    if (id != 0 ){
        viewModel.getContactWithId(id!!)
    }
    if (!contact.value?.name.isNullOrEmpty() && name.value == ""){
        name.value = contact.value!!.name
        phone.value = contact.value!!.phone
    }

    Column(Modifier.fillMaxSize()) {
        TopAppBar(title = { Text(text = "New Contact", fontFamily = quickSand, fontSize = 20.sp) })
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.user_default1),
                contentDescription = "",
                modifier = Modifier.size(70.dp)
            )
            Text(text = "Choose an avatar", fontFamily = quickSand, fontSize = 15.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = name.value,
            onValueChange = {name.value = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                containerColor = Color(0xFFEBEBEB)
            ),
            placeholder = {
                Text(
                    text = "Name",
                    fontFamily = quickSand,
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = phone.value,
            onValueChange = {phone.value = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                containerColor = Color(0xFFEBEBEB)
            ),
            placeholder = {
                Text(
                    text = "Phone",
                    fontFamily = quickSand,
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                if (!name.value.isNullOrEmpty() && phone.value.length == 10){
                    if (id != 0){
                        val con = Contacts(
                            id = id,
                            name = name.value,
                            phone = phone.value,
                            favorite = contact.value!!.favorite
                        )
                        viewModel.updateContact(con)
                    }else{
                        val con = Contacts(
                            name = name.value,
                            phone = phone.value,
                            favorite = false
                        )
                        viewModel.addContact(con)
                    }
                    navController.navigate(BottomBarScreen.contacts.route)
                }else{
                    Toast.makeText(context, "Please fill the details correctly", Toast.LENGTH_SHORT).show()
                }
                      },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Text(text = "Save", fontFamily = quickSand, fontSize = 15.sp)
        }
    }
}