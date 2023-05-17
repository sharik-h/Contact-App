package com.example.contactapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.contactapp.MainUI.contactPage
import com.example.contactapp.MainUI.dailPage
import com.example.contactapp.MainUI.favoritesPage
import com.example.contactapp.MainUI.newContactPage
import com.example.contactapp.MainUI.recentPage

@Composable
fun bottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.contacts.route
    ){
        composable(route = BottomBarScreen.contacts.route){
            contactPage()
        }
        composable(route = BottomBarScreen.recents.route){
            recentPage()
        }
        composable(route = BottomBarScreen.dail.route){
         dailPage()
        }
        composable(route = BottomBarScreen.favorite.route){
            favoritesPage()
        }
        composable(route = BottomBarScreen.add.route){
            newContactPage()
        }
    }
}