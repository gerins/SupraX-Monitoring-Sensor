package com.example.suprax_monitoring_sensor.domains.sensor

import androidx.lifecycle.MutableLiveData
import com.example.suprax_monitoring_sensor.domains.sensor.model.Sensor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SensorRepository(val sensorAPI: SensorAPI) {
    var sensorLiveData = MutableLiveData<Sensor>()

    fun fetchSensorData() {
        sensorAPI.fetchSensorData()
            .enqueue(object : Callback<Sensor> {
                override fun onResponse(
                    call: Call<Sensor>,
                    response: Response<Sensor>
                ) {
                    if (response.code() == 200) {
                        sensorLiveData.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Sensor>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }
}