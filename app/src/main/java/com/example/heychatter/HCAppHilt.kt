package com.example.heychatter

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HCAppHilt :Application()



/*Hilt Initialization:
 The @HiltAndroidApp annotation triggers Hilt's code generation, including a base class for the application that serves as the application-level dependency container.
Dependency Injection:
 It enables dependency injection for the entire app, allowing Hilt to provide dependencies to Android components.
Application Class:
The HCAppHilt class extends Application, making it the starting point of the app where global configuration can be set up.
Simplifies DI:
Using Hilt simplifies the setup of dependency injection, reducing boilerplate and improving maintainability by managing dependencies automatically.*/