package com.example.heychatter.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.heychatter.BottomNavigationItem

@Composable
fun StatusScreen(AppnavController: NavController) {
    com.example.heychatter.BottomNavigationMenu(selectedItem = BottomNavigationItem.STATUSLIST, navController = AppnavController)

}