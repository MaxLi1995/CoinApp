package com.maxli.myapplication3.data

import com.squareup.moshi.Json
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.round


data class ApiData(
    val data: List<Data>
)

data class Data(
    val id: String,

    val symbol: String,

    val name: String,

    @Json(name = "priceUsd")
    val price: String,

    @Json(name = "marketCapUsd")
    val marketCap: String,

    val supply: String,

    @Json(name = "volumeUsd24Hr")
    val volume: String,

    @Json(name = "changePercent24Hr")
    val change: String


) {
    fun getFormattedPrice(): String {
        return String.format("$ %.2f", price.toDouble())
    }
    fun getFormattedMarketCap(): String{
        return prettyCount(marketCap.toDouble())
    }
    fun getFormattedSupply(): String{
        return prettyCount(supply.toDouble())
    }
    fun getFormattedVolume(): String{
        return prettyCount(volume.toDouble())
    }
    fun getPercentageChange(): String{
        return String.format("%.2f", change.toDouble()) + " %"
    }


    private fun prettyCount(number: Double): String {
        val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
        val numValue = number.toLong()
        val value = floor(log10(numValue.toDouble())).toInt()
        val base = value / 3
        return if (value >= 3 && base < suffix.size) {
            DecimalFormat("#0.0").format(
                numValue / 10.0.pow((base * 3).toDouble())
            ) + suffix[base]
        } else {
            DecimalFormat("#,##0").format(numValue)
        }
    }
}