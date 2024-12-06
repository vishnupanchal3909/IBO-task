package com.example.coding

class ItemRepo {
    val apiService = RetofitInstance.api
    suspend fun fetchData() = apiService.getItem()
}