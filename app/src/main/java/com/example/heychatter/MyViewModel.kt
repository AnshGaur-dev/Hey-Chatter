package com.example.heychatter

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject
import kotlin.math.sign

@HiltViewModel
class MyViewModel @Inject constructor(
    private val auth: FirebaseAuth
) : ViewModel() {

    var inProcess = mutableStateOf(false)
    val eventMutableState = mutableStateOf<Event<String>?>(null)
    var signincheck= mutableStateOf(false)

    fun signup(name: String, number: String, email: String, password: String) {
        inProcess.value = true
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                signincheck.value=true
                
            } else {
                handleException(it.exception, "Signup failed")
            }
        }
    }

    fun handleException(exception: Exception? = null, customMessage: String? = null) {
        Log.d("Error", "Signup failed: ", exception)
        exception?.printStackTrace()
        val errorMsg = exception?.localizedMessage ?: "Unknown error occurred"
        val message = customMessage ?: errorMsg
        eventMutableState.value = Event(message)
    }
}
