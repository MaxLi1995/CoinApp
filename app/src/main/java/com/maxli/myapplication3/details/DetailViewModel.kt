package com.maxli.myapplication3.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxli.myapplication3.data.CoinApi
import com.maxli.myapplication3.data.Data
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private val _coin = MutableLiveData<Data>()
    val coin : LiveData<Data> = _coin

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing : LiveData<Boolean> = _isRefreshing


    private fun setRefreshing(isRefreshing : Boolean) {
        _isRefreshing.value = isRefreshing
    }

    fun getData(id: String) {
        setRefreshing(true)
        viewModelScope.launch {
            _coin.value = CoinApi.retrofitService.getData().data.first { it.id == id }
            setRefreshing(false)
        }
    }
}