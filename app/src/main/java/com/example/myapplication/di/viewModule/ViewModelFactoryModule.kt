package com.example.myapplication.di.viewModule

import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ui.base.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}