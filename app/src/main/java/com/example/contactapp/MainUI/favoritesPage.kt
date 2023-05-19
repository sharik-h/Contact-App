package com.example.contactapp.MainUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.contactapp.Database.ViewModel.MainViewModel
import com.example.contactapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun favoritesPage(viewModel: MainViewModel) {

    val quickSand = FontFamily(Font(R.font.quicksand))
    viewModel.getAllFavorites()
    val allFavorites = viewModel.allFavorite.observeAsState()

    Column(Modifier.fillMaxSize()) {
        TopAppBar(title = { Text(text = "Favorite", fontFamily = quickSand, fontSize = 20.sp) })
        LazyColumn{
            if (!allFavorites.value.isNullOrEmpty()){
                items(allFavorites.value!!){favorite ->
                    contactListModel(name = favorite.name, phone = favorite.phone, favorite = favorite.favorite){
                        if (it == "favorite"){
                            viewModel.updateFavorite(favorite.id, !favorite.favorite)
                        }
                    }
                }
            }
        }
    }

}