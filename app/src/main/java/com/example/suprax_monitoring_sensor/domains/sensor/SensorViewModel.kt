package com.example.suprax_monitoring_sensor.domains.sensor

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.suprax_monitoring_sensor.domains.sensor.model.Sensor


class SensorViewModel(private val sensorRepository: SensorRepository) : ViewModel() {
    fun getSensorData() = sensorRepository.sensorLiveData as LiveData<Sensor>

    fun fetchSensorData() = sensorRepository.fetchSensorData()
}