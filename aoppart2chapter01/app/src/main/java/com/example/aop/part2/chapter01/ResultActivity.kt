package com.example.aop.part2.chapter01

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)

        val bmi = weight / (height / 100.0).pow(2.0)
        val resultText = when{
            bmi >= 35.0 ->"고도비만"
            bmi >= 30.0 ->"중도비만"
            bmi >= 25.0 ->"경도비만"
            bmi >= 23.0 ->"과체중"
            bmi >= 18.5 ->"정상"
            else -> "저체중"
        }

        val resultValueTextView = findViewById<TextView>(R.id.BmiResultTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText

    }

}