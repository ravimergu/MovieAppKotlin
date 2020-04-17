package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.AppComponent
import com.example.myapplication.di.DaggerAppComponent

class MyApp: Application() {

   val appComponent:AppComponent = DaggerAppComponent.create()
}