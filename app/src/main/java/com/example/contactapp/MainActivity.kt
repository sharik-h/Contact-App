package com.example.contactapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.contactapp.Application.Mainapplication
import com.example.contactapp.Database.ViewModel.MainViewModel
import com.example.contactapp.Database.ViewModel.MainViewModelFactory
import com.example.contactapp.Navigation.MainScreen
import com.example.contactapp.ui.theme.ContactAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainViewModel by viewModels {
            MainViewModelFactory(
                contactRepo = (application as Mainapplication).contactRepository,
                recentRepo = (application as Mainapplication).recentsRepository,
            )
        }
        viewModel.getAllContacts()
        setContent {
            ContactAppTheme {
                MainScreen(viewModel)
            }
        }
    }
}

