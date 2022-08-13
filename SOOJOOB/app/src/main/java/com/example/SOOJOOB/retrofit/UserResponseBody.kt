package com.example.SOOJOOB.retrofit

import com.google.gson.annotations.SerializedName

data class UserResponseBody(
    @SerializedName("statusCode")
    val statusCode: Int?,
    @SerializedName("msg")
    val msg: String?,
    @SerializedName("data")
    val data: UserData?
)

data class UserData(
    @SerializedName("userRecord")
    val userRecord: UserRecord?,
    @SerializedName("totalDistance")
    val totalDistance: Double?,
    @SerializedName("totalTrashCount")
    val totalTrashCount: Int?,
    @SerializedName("totalTimeRecord")
    val totalTimeRecord: Int?,
    @SerializedName("badgeCount")
    val badgeCount: Int?,
    @SerializedName("exp")
    val exp: Double?
)

data class UserRecord(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String
)