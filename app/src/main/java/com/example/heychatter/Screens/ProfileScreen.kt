package com.example.heychatter.Screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.heychatter.BottomNavigationItem

@Composable
fun ProfileScreen (AppnavController: NavController){
    Text(text = "Hello Profile")
    com.example.heychatter.BottomNavigationMenu(selectedItem = BottomNavigationItem.PROFILE, navController = AppnavController)

}