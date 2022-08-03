package com.example.aop.part2.health_connect_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.health.connect.client.HealthConnectClient
import androidx.health.platform.client.proto.PermissionProto


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val PERMISSIONS =
            setOf(
                PermissionProto.Permission.createReadPermission(HeartRateSeries::class),
                Permission.createWritePermission(HeartRateSeries::class),
                Permission.createReadPermission(Steps::class),
                Permission.createWritePermission(Steps::class)
            )

// Create the permissions launcher.
        val requestPermissions =
            registerForActivityResult(HealthDataRequestPermissions()) { granted ->
                if (granted.containsAll(PERMISSIONS)) {
                    // Permissions successfully granted
                } else {
                    // Lack of required permissions
                }
            }



        if (HealthConnectClient.isAvailable(context)) {
            // Health Connect is available and installed.
            val healthConnectClient = HealthConnectClient.getOrCreate(context)
        } else {

        }

    }


}