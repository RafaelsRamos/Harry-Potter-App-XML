package com.scookie.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object APIClient {

    private const val HARRY_POTTER_BASE_URL = "https://hp-api.onrender.com/api/"

    val hpRetrofit by lazy { createRetrofit() }

    private fun createRetrofit(): Retrofit {

        val httpClient = OkHttpClient
            .Builder()
            .addLoggingInterceptor()
            .build()

        return Retrofit
            .Builder()
            .baseUrl(HARRY_POTTER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()

    }

    private fun OkHttpClient.Builder.addLoggingInterceptor() = apply {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        addInterceptor(loggingInterceptor)
    }

}