package com.example.SOOJOOB

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.SOOJOOB.databinding.ActivityArticleBinding
import com.example.SOOJOOB.retrofit.RetrofitAPI
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

class ArticleActivity : AppCompatActivity() {
    private var res: List<Any>? = null
    private lateinit var recyler_view: RecyclerView
    private lateinit var title:TextView
    private lateinit var contents:TextView
    private lateinit var dateTime:TextView


    private lateinit var binding: ActivityArticleBinding



    fun work(){
        val service = RetrofitAPI.articleService

        service.getArticle()
            .enqueue(object: retrofit2.Callback<ArticleGetResponseBody>{
                override fun onResponse(
                    call: Call<ArticleGetResponseBody>,
                    response: Response<ArticleGetResponseBody>
                ) {
                    if (response.isSuccessful) {
                        val result = response.body()
                        result?.let {
                            it.result?.let { it1 -> setAdapter(it1) }
                        }
                    }
                }

                override fun onFailure(call: Call<ArticleGetResponseBody>, t: Throwable) {
                    Log.d("게시글  get 실패", t.message.toString())
                }
            })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyler_view = findViewById(R.id.recyler_view)

        this.work()
        println("게시판 데이터 get 호출!!")



    }

    private fun setAdapter(ArticleList : List<Article>){
        val mAdapter = ArticleAdapter( ArticleList)
        recyler_view.adapter = mAdapter
        recyler_view.layoutManager = GridLayoutManager(this,1, GridLayoutManager.VERTICAL,
            false)

        recyler_view.setHasFixedSize(false)
    }





}