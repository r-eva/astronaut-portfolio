package com.example.astronautportfolio

import android.app.Application
import android.content.SharedPreferences
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.remote.AstronautAPI
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AstronautsApp: Application() {
    companion object {
        lateinit var apiService: AstronautAPI
            private set

        lateinit var database: AstronautDatabase
            private set

        lateinit var sharedPreferences: SharedPreferences
            private set
    }
}