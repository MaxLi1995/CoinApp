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


    init{
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _coins.value = CoinApi.retrofitService.getData().data
        }
    }
}