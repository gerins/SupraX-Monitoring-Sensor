package com.example.suprax_monitoring_sensor.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun defaultHost():String{
    return "http://192.168.43.130"
}

class RetrofitBuilder{
    companion object {
        private val BASE_URL = defaultHost()

        fun createRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
