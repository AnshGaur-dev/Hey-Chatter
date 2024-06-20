package com.example.heychatter

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.heychatter.data.USER_NODE
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject
import kotlin.math.sign
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject


@HiltViewModel
class MyViewModel @Inject constructor(
    val auth: FirebaseAuth,//yeah HILTMODULE se aa raha h
    var db: FirebaseFirestore//yeah bhi HILTMODULE se aa raha h
) : ViewModel() {

    var inProcess = mutableStateOf(false)
    val eventMutableState = mutableStateOf<Event<String>?>(null)
    var signincheck = mutableStateOf(false)
     var userData = mutableStateOf<UserData?>(null)

    fun signup(name: String, number: String, email: String, password: String) {
        inProcess.value = true
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                signincheck.value = true
                inProcess.value = false
                CreateOrUpdateProfile(name, number, imageurl = null)
            } else {
                handleException(it.exception, "Signup failed")
            }
        }
    }

    fun CreateOrUpdateProfile(
        name: String? = null,
        number: String? = null,
        imageurl: String? = null
    ) {
        var uid = auth.currentUser?.uid //accessing userid
        val userData = UserData(
            name =name?: userData.value?.name,
            number = number?:userData.value?.number,
            imageurl =imageurl?: userData.value?.imageurl,
            userid = uid
        )
        uid?.let {
            inProcess.value = true
            db.collection(USER_NODE).document(uid).get().addOnSuccessListener {
                if (it.exists()) {
                //Yeah Update k liye h

                } else {
                    getUserData(uid)
                }
            }.addOnFailureListener{
                handleException(it,"Cannot Retrive User")
            }
        }
    }

    fun handleException(exception: Exception? = null, customMessage: String? = null) {
        Log.d("Error", "Signup failed: ", exception)
        exception?.printStackTrace()
        val errorMsg = exception?.localizedMessage ?: "Unknown error occurred"
        val message = customMessage ?: errorMsg
        eventMutableState.value = Event(message)
        inProcess.value = false
    }
    fun getUserData(uid:String){
        inProcess.value=true
        db.collection(USER_NODE).document(uid).addSnapshotListener{
            value,error->
            if(value!=null){
                var user=value.toObject<UserData>()
                userData.value=user
                inProcess.value=false
            }
            if (error!=null){
                handleException(error,"Cannot Retrive User")
            }
        }


    }
}
