package com.example.aop.part2.health_connect_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.health.connect.client.HealthConnectClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (HealthConnectClient.isAvailable(context)) {
            // Health Connect is available and installed.
            val healthConnectClient = HealthConnectClient.getOrCreate(context)
        } else {
            // ...
        }
    }

}