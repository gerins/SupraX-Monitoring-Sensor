package com.example.suprax_monitoring_sensor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.suprax_monitoring_sensor.domains.sensor.SensorViewModel
import com.example.suprax_monitoring_sensor.config.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    lateinit var sensorViewModel: SensorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorViewModel =
            ViewModelProvider(this, InjectorUtils.provideSensorViewModelFactory()).get(
                SensorViewModel::class.java
            )

        Timer("SettingUp", true).schedule(200, 1000) {
            sensorViewModel.fetchSensorData()
        }

        sensorViewModel.getSensorData().observe(this, {
            temp_view.text = "${it.temp.toBigDecimal().setScale(1, RoundingMode.UP)} C"
            engine_view.text = "${it.engine.toBigDecimal().setScale(1, RoundingMode.UP)} C"
            battery_view.text = "${it.battery.toBigDecimal().setScale(1, RoundingMode.UP)} V"
            altitude_view.text = "${it.altitude.toInt()} MDPL"
        })
    }
}