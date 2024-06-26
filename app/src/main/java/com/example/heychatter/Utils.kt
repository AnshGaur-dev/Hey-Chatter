package com.example.heychatter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.Navigator

fun navigateTo(navController: NavController, route: String) {
    navController.navigate(route) {
        popUpTo(route)
        launchSingleTop = true
    }
}

@Composable
fun CommonProgressBar() {
    Row(modifier = Modifier
        .alpha(0.5f)
        .background(Color.LightGray)
        .clickable(enabled = false) {}
        .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        CircularProgressIndicator()
    }
}

@Composable
fun CheckSignedin(vm: MyViewModel, navController: NavController) {
    val alreadySignIn = remember { mutableStateOf(false) }
    val signIn=vm.signincheck.value
    if (signIn && !alreadySignIn.value){
        navController.navigate(DestinationScreen.ChatList.route){
            popUpTo(0)
        }

    }


}