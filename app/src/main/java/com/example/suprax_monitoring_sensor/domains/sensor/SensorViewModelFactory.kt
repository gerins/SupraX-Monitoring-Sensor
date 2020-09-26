package com.example.suprax_monitoring_sensor.domains.sensor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SensorViewModelFactory(private val sensorRepository: SensorRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SensorViewModel(sensorRepository) as T
    }
}