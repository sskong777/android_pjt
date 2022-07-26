package com.example.SOOJOOB

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ArticleGetResponseBody(
    @SerializedName("statusCode")
    val statusCode: Int?,
    @SerializedName("msg")
    val msg: String?,
    @SerializedName("data")
    val result: List<Article>?
)
@Parcelize
data class Article(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("contents")
    val contents: String?,
    @SerializedName("createdDate")
    val createdDate: String?,
    @SerializedName("articleImage")
    val articleImage: String?,
    @SerializedName("userName")
    val userName:String?
): Parcelable

