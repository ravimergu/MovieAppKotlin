package com.example.myapplication.ui.main.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.data.repository.MainRepository
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.*
import javax.inject.Inject

class MainViewModel @Inject constructor( private val  mainRepository: MainRepository) : ViewModel() {

    fun getUsers1(){

    }
    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(null, exception.message))
        }
    }
}