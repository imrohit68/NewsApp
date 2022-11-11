package com.example.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val Base_URL = "https://newsapi.org"
const val API_Key = "491d2bb6ec214f7bb2bdf6f7f073226e"

interface NewsInterface{
    @GET("v2/top-headlines?apiKey=$API_Key")
    fun getHeadlines(@Query(value = "country")country:String,@Query(value = "page")page:Int) : Call<News>
}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}