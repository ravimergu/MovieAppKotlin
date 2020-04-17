package com.example.myapplication.data.repository

import com.example.myapplication.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor( private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUser()
}