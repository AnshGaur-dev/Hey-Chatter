package com.example.heychatter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heychatter.Screens.*
import com.example.heychatter.ui.theme.HeyChatterTheme
import dagger.hilt.android.AndroidEntryPoint

sealed class DestinationScreen(var route: String) {
    object Signup : DestinationScreen("signup")
    object Login : DestinationScreen("login")
    object Profile : DestinationScreen("profile")
    object ChatList : DestinationScreen("chatList")
    object SingleChat : DestinationScreen("SingleChat/{chatId}") {
        fun createRoute(id: String) = "singlechat/$id"
    }
    object StatusList : DestinationScreen("StatusList")
    object SingleStatus : DestinationScreen("SingleStatus/{userId}") {
        fun createRoute(userId: String) = "SingleStatus/$userId"
    }
}

@AndroidEntryPoint
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
    fun ChatAppNavigation() {
        val appNavController = rememberNavController()
        val vm: MyViewModel = hiltViewModel()
        NavHost(navController = appNavController, startDestination = DestinationScreen.Signup.route) {
            composable(DestinationScreen.Signup.route) {
                SignupScreen(appNavController, vm)
            }
            composable(DestinationScreen.Login.route) {
                LoginScreen(appNavController)
            }
            composable(DestinationScreen.ChatList.route) {
                ChatListScreen(appNavController)
            }
            composable(DestinationScreen.SingleChat.route) {
                SingleChatScreen(appNavController)
            }
            composable(DestinationScreen.Profile.route) {
                ProfileScreen(appNavController)
            }
            composable(DestinationScreen.SingleStatus.route) {
                SingleStatusScreen(appNavController)
            }
            composable(DestinationScreen.StatusList.route) {
                StatusScreen(appNavController)
            }
        }
    }
}
