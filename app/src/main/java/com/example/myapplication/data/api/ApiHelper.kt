package com.example.myapplication.data.api

import javax.inject.Inject

class ApiHelper @Inject constructor( private val  apiService: ApiService) {
    suspend fun getUser()=apiService.getUsers();
}