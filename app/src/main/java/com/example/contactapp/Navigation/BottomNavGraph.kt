package com.example.contactapp.Navigation

import com.example.contactapp.Database.Entity.Contacts
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.contactapp.Database.ViewModel.MainViewModel
import com.example.contactapp.MainUI.contactPage
import com.example.contactapp.MainUI.dailPage
import com.example.contactapp.MainUI.favoritesPage
import com.example.contactapp.MainUI.newContactPage
import com.example.contactapp.MainUI.recentPage

@Composable
fun bottomNavGraph(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.contacts.route
    ){
        composable(route = BottomBarScreen.contacts.route){
            contactPage(viewModel = viewModel, navController = navController)
        }
        composable(route = BottomBarScreen.recents.route){
            recentPage(viewModel = viewModel)
        }
        composable(route = BottomBarScreen.dail.route){
         dailPage(viewModel)
        }
        composable(route = BottomBarScreen.favorite.route){
            favoritesPage(viewModel)
        }
        composable(
            route = BottomBarScreen.add.route,
            arguments = listOf(navArgument(name = "id")
            {
                type = NavType.IntType
                defaultValue = 0
            })
        ){
            val id = it.arguments?.getInt("id")
            newContactPage(viewModel = viewModel, navController = navController, id = id)
        }
    }
}