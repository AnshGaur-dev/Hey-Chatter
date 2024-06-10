package com.example.heychatter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heychatter.Screens.ChatListScreen
import com.example.heychatter.Screens.LoginScreen
import com.example.heychatter.Screens.ProfileScreen
import com.example.heychatter.Screens.SignupScreen
import com.example.heychatter.Screens.SingleChatScreen
import com.example.heychatter.Screens.SingleStatusScreen
import com.example.heychatter.Screens.StatusScreen
import com.example.heychatter.ui.theme.HeyChatterTheme


sealed class DestinationScreen(var route:String){
    object Signup:DestinationScreen("signup")
    object Login:DestinationScreen("login")
    object Profile:DestinationScreen("profile")
    object ChatList:DestinationScreen("chatList")
    object SingleChat:DestinationScreen("SingleChat/{chatId}"){
        fun createRoute(id:String)="singlechat/$id"
    }
    object StatusList:DestinationScreen("StatusList")

    object SingleStatus:DestinationScreen("SingleStatus/{userId}"){
        fun createRoute(userid:String)="SingleStatus/$userid"
    }
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeyChatterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChatAppNavigation()
                }
            }
        }
    }
    @Composable
    fun ChatAppNavigation(){
        val AppnavController= rememberNavController()
        var vm= hiltViewModel<MyViewModel>()
        NavHost(navController =AppnavController , startDestination = "signup"){
            composable(DestinationScreen.Signup.route){
                    SignupScreen(AppnavController,vm)
            }
            composable(DestinationScreen.Login.route){
                LoginScreen(AppnavController)
            }
            composable(DestinationScreen.ChatList.route){
                ChatListScreen(AppnavController)
            }
            composable(DestinationScreen.SingleChat.route){
                SingleChatScreen(AppnavController)
            }
            composable(DestinationScreen.Profile.route){
                ProfileScreen(AppnavController)
            }
            composable(DestinationScreen.SingleStatus.route){
                SingleStatusScreen(AppnavController)
            }
            composable(DestinationScreen.StatusList.route){
                StatusScreen(AppnavController)
            }
        }
    }
}
