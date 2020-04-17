package com.example.myapplication.di

import com.example.myapplication.data.api.ApiHelper
import com.example.myapplication.data.api.ApiService
import com.example.myapplication.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetModule {
    @JvmStatic
    @Provides
    fun provideLoginRetrofitService(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://5e510330f2c0d300147c034c.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

    @JvmStatic
    @Provides
    fun provideApiHelper(apiService: ApiService):ApiHelper{
        return  ApiHelper(apiService)
    }
    @JvmStatic
    @Provides
    fun provideMainRepository(apiHelper: ApiHelper):MainRepository{
        return  MainRepository(apiHelper)
    }

    @JvmStatic
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level=HttpLoggingInterceptor.Level.BODY }
    }

    @JvmStatic
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build();
    }

}