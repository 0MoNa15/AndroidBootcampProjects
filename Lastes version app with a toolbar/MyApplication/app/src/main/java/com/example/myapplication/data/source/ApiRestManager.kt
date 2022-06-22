package com.example.myapplication.data.source

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiRestManager {

    private const val url: String = "https://api.themoviedb.org/3/"
    const val apiKey: String = "c5c47722a4adcc77f6e84f28a48b857a"


    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
    private val gson = GsonBuilder()
        .setLenient()
        .create()
    fun create(): RetrofitMovieDataSource {
        val builder = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
        val mRetrofit = builder.build()
        return mRetrofit.create(RetrofitMovieDataSource::class.java)
    }
}