package com.example.heychatter.Screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.heychatter.BottomNavigationItem

@Composable
fun ChatListScreen(AppnavController: NavController) {
    Text(text = "Hello Chatlist")
    com.example.heychatter.BottomNavigationMenu(
        selectedItem = BottomNavigationItem.CHATLIST,
        navController = AppnavController
    )
}