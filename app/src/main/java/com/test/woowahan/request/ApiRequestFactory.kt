package com.test.woowahan.request

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRequestFactory {

    private const val baseUrl = "https://l2f9wtenm7.execute-api.ap-northeast-2.amazonaws.com/"

    val retrofit: Service = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY }).build())
        .build()
        .create(Service::class.java)
}