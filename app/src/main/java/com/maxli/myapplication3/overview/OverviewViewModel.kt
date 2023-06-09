package com.maxli.myapplication3.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxli.myapplication3.data.*
import kotlinx.coroutines.launch

class OverviewViewModel: ViewModel() {

    private val _coins = MutableLiveData<List<Data>>()
    val coins : LiveData<List<Data>> = _coins

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing : LiveData<Boolean> = _isRefreshing


    init{
        getData()
    }

    private fun setRefreshing(isRefreshing : Boolean) {
        _isRefreshing.value = isRefreshing
    }

    fun getData() {
        setRefreshing(true)
        viewModelScope.launch {
            _coins.value = CoinApi.retrofitService.getData().data
            setRefreshing(false)
        }
    }
}