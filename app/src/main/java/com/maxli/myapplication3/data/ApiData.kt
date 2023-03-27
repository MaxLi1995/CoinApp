package com.maxli.myapplication3.data

import com.squareup.moshi.Json


data class ApiData(
    val data: List<Data>
)

data class Data(
    val id: String,

    val symbol: String,

    @Json(name = "priceUsd")
    val price: String
)