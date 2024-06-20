package com.example.heychatter.di

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class HiltModule {
    @Provides
    @ViewModelScoped//The @ViewModelScoped annotation in Dagger Hilt ensures that a dependency, such as FirebaseAuth, is created once per ViewModel instance and reused within that ViewModel.
    fun provideAuthentication(): FirebaseAuth = FirebaseAuth.getInstance()

     }

//@Module: This tells Hilt that this class provides dependencies.
//@InstallIn(SingletonComponent::class): This makes the dependencies available everywhere in the app.
//object HiltModule: This is a singleton object, meaning there will be only one instance of it.
//@Provides: This tells Hilt that the following function provides a dependency.
//@Singleton: This means the provided dependency will be a singleton (only one instance for the whole app).
//fun provideAuthentication(): FirebaseAuth = FirebaseAuth.getInstance(): This function provides the Firebase Authentication instance.
