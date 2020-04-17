package com.example.myapplication.di

import com.example.myapplication.di.viewModule.ViewModelFactoryModule
import com.example.myapplication.di.viewModule.ViewModelModule
import com.example.myapplication.ui.main.view.MainActivity
import dagger.Component

@Component(modules = [AppModule::class,NetModule::class,ViewModelFactoryModule::class,ViewModelModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}