package com.example.googlemap02



import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.model.*


internal class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_maps = findViewById(R.id.button_maps) as Button

        val mapsIntent = Intent(this, MapsActivity::class.java) // 인텐트를 생성

        btn_maps.setOnClickListener { // 버튼 클릭시 할 행동
            startActivity(mapsIntent)  // 화면 전환하기
        }


        var btn_current = findViewById(R.id.button_current) as Button

        val currentIntent = Intent(this, CurrentPlaceActivity::class.java) // 인텐트를 생성

        btn_current.setOnClickListener { // 버튼 클릭시 할 행동
            startActivity(currentIntent)  // 화면 전환하기
        }
    }
}