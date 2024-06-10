package com.example.heychatter

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor():ViewModel() {

}
//open class BaseViewModel : ViewModel() {
//
//}
//
//@HiltViewModel
//class MyViewModel @Inject constructor(
//
//) : BaseViewModel() {
//
//}