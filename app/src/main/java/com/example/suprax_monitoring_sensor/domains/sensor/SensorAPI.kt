package com.example.suprax_monitoring_sensor.domains.sensor

import com.example.suprax_monitoring_sensor.domains.sensor.model.Sensor
import retrofit2.Call
import retrofit2.http.GET


interface SensorAPI {
    @GET("/sensor")
    fun fetchSensorData(): Call<Sensor>
}