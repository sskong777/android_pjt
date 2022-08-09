package com.example.proto04

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PloggingService {

        @Headers("X-Auth-Token: eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJzdWIiOiJ0anJndXM3NzdAdGpyZ3VzLmNvbSIsImVtYWlsIjoidGpyZ3VzNzc3QHRqcmd1cy5jb20iLCJpYXQiOjE2NjAwMTIyMzUsImV4cCI6MTY2MDAyNjYzNX0.Z6F_DXQEcTDnrfaPm37iK_pyQiiAH_zWD_H2m9F_cKI",
        "Content-Type: application/json")
        @POST("plogging")
        fun addPloggingByEnqueue(@Body ploggingInfo: RequestBody): Call<PloggingResponseBody> // Call 은 흐름처리 기능을 제공해줌
    }
