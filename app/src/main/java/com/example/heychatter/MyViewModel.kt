package com.example.heychatter

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val auth: FirebaseAuth
) : ViewModel() {

    fun signup(name: String, number: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("Success", "Signup done")
            } else {
                Log.d("Error", "Signup failed: ${it.exception?.message}")
            }
        }
    }
}
