package com.example.coding

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetofitInstance {

    const val Base_url = "https://www.whats-on-netflix.com/wp-content/plugins/whats-on-netflix/json/"

    val api : ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}