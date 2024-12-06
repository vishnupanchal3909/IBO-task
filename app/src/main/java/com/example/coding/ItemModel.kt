package com.example.coding

import retrofit2.http.GET

data class ItemModel (
    val title : String,
    val image_portrait : String,
)


interface  ApiService{
    @GET("alldocs.json?_=1700718031139")
    suspend fun getItem():List<ItemModel>
}