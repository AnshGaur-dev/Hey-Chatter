package com.example.heychatter.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.heychatter.DestinationScreen
import com.example.heychatter.MyViewModel
import com.example.heychatter.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(AppnavController: NavController,vm:MyViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        val emailState = remember { mutableStateOf(TextFieldValue()) }
        val passwordState = remember { mutableStateOf(TextFieldValue()) }

        Image(
            painter = painterResource(id = R.drawable.signupbackground),
            contentDescription = "Demo image",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 50.dp)
        ) {
            Text(
                text = "Login",
                color = Color.Black,
                fontFamily = FontFamily.Monospace,
                fontSize = 30.sp,
                modifier = Modifier.padding(top = 30.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))

//            TextField(
//                value = numberState.value,
//                onValueChange = { numberState.value = it },
//                label = { Text(text = "Number") },
//                modifier = Modifier
//                    .padding(8.dp)
//                    .border(
//                        border = BorderStroke(1.dp, Color.Black),
//                        shape = MaterialTheme.shapes.small
//                    ),
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedLabelColor = Color.Black,
//                    unfocusedLabelColor = Color.Black,
//                    focusedBorderColor = Color.Black,
//                    unfocusedBorderColor = Color.Black,
//                )
//            )
//            Spacer(modifier = Modifier.height(18.dp))

            TextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text(text = "Email") },
                modifier = Modifier
                    .padding(8.dp)
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = MaterialTheme.shapes.small
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                )
            )
            Spacer(modifier = Modifier.height(25.dp))

            TextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                label = { Text(text = "Password") },
                modifier = Modifier
                    .padding(8.dp)
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = MaterialTheme.shapes.small
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    vm.signIn(email = emailState.value.text, password = passwordState.value.text)
                    AppnavController.navigate(DestinationScreen.ChatList.route)
                },
                modifier = Modifier.size(width = 150.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                )
            ) {
                Text(text = "Login")
            }

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Don't have an account yet?Click here",
                color = Color.Black,
                modifier = Modifier.clickable {
                    AppnavController.navigate(DestinationScreen.Signup.route)
                },
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}