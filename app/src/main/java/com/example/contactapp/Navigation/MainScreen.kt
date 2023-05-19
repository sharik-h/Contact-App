package com.example.contactapp.Navigation

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.contactapp.Database.ViewModel.MainViewModel
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.balltrajectory.Straight
import com.exyte.animatednavbar.animation.balltrajectory.Teleport
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { bottomBar(navController = navController ) }
    ) {
        val pad = it
        bottomNavGraph(navController = navController, viewModel = viewModel)
    }
}

@Composable
fun bottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.recents,
        BottomBarScreen.contacts,
        BottomBarScreen.add,
        BottomBarScreen.favorite,
        BottomBarScreen.dail
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var selectedIndex by remember { mutableStateOf(1) }
//    NavigationBar {
    AnimatedNavigationBar(
        selectedIndex =selectedIndex,
        modifier = Modifier.height(64.dp),
        ballAnimation = Teleport(tween(1000)),
        indentAnimation = Height(tween(1000)),
        barColor = MaterialTheme.colorScheme.primary,
        ballColor = MaterialTheme.colorScheme.primary
    ) {
        screens.forEach{screen ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .noRippleClickable {
                        navController.navigate(screen.route){
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                        selectedIndex = screens.indexOf(screen)
                                       },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = screen.icon,
                    contentDescription = "",
                    modifier = Modifier.size(26.dp),
                    tint = if (selectedIndex == screens.indexOf(screen)) {MaterialTheme.colorScheme.onPrimary}
                           else{ MaterialTheme.colorScheme.inversePrimary }
                )
            }
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
   NavigationBarItem(
       label = {
               Text(text = screen.title)
       },
       icon = {
              Image(imageVector = screen.icon, contentDescription = "")
       },
       selected = currentDestination?.hierarchy?.any {
           it.route == screen.route
       } == true,
       colors = NavigationBarItemDefaults.colors(unselectedIconColor = Color.LightGray, unselectedTextColor = Color.LightGray),
       onClick = { navController.navigate(screen.route){
           popUpTo(navController.graph.findStartDestination().id)
           launchSingleTop = true
       } })
}