package com.example.myapplication.di.viewModule

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.viewModule.ViewModelKey
import com.example.myapplication.ui.main.viewModel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMyViewModel(myViewModel: MainViewModel): ViewModel
}