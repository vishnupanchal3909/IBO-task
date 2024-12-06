package com.example.coding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemViewModel(val repsitory : ItemRepo):ViewModel() {
   /* val item = MutableLiveData<List<ItemModel>>()
    suspend fun loadItem(){
        viewModelFactory {
            try{
                val response = repsitory.fetchData()
                item.postValue(response)
            }catch(e:Exception){
                item.postValue(emptyList())
            }l
        }
    }*/
   val _item = MutableStateFlow<List<ItemModel>>(emptyList())
    val item : StateFlow<List<ItemModel>> get() = _item
    fun loadItem() {
        viewModelScope.launch {
            try {
                _item.value = repsitory.fetchData()
            } catch (e: Exception) {
                _item.value = emptyList()
            }

        }
    }

}