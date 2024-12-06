package com.example.coding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory (val resp: ItemRepo):ViewModelProvider.Factory{

    override fun <T:ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(ItemViewModel::class.java)){
            return ItemViewModel(resp) as T
        }
        throw IllegalArgumentException("Unknow Exception")
    }
}