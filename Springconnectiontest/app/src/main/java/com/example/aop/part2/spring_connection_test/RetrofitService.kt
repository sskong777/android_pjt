package com.example.aop.part2.spring_connection_test

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object {
        //통신할 서버 url
        private const val baseUrl = "http://12.345.678.910"

        //Retrofit 객체 초기화
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(this.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val test: TestService = retrofit.create(TestService::class.java)
    }
}