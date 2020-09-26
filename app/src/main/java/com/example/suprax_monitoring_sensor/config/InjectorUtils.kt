package com.example.suprax_monitoring_sensor.config

import com.example.suprax_monitoring_sensor.domains.sensor.SensorAPI
import com.example.suprax_monitoring_sensor.domains.sensor.SensorRepository
import com.example.suprax_monitoring_sensor.domains.sensor.SensorViewModelFactory

object InjectorUtils {
    fun provideSensorViewModelFactory(): SensorViewModelFactory {
        val sensorRepository =
            SensorRepository(RetrofitBuilder.createRetrofit().create(SensorAPI::class.java))

        return SensorViewModelFactory(sensorRepository)
    }
}