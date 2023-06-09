package com.example.dz2_month5

import android.content.Context
import android.content.SharedPreferences
import com.example.dz2_month5.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModel {
    @Provides
    fun provideApi(): LoveApi {
     return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/").addConverterFactory(
         GsonConverterFactory.create()
     ).build().create(LoveApi::class.java)
    }
    @Provides
    fun providePreference(context: Context):SharedPreferences{
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }
    companion object {
        const val PREF_NAME = "PREF"
    }
}